package Tests;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class TC02_OrderApisTest {
	 private String orderId;
	@Test(priority = 1)
	public void testCreateOrder() {		
	     final BookData bookData = new BookData(1, "Nada");

	        this.orderId = given().when()
	                .log()
	                .all()
	                .contentType(ContentType.JSON)
	                .header("Authorization", "0f9e9fb043905072793dcf86dbe985b0cf2798dde153cd2b51004676d0284f80")
	                .body(bookData)
	                .post("https://simple-books-api.glitch.me/orders")
	                .then()
	                .log().all()
	                .statusCode(201)
	                .body("created", equalTo(true), "orderId", is(notNullValue()))
	                .extract()
	                .path("orderId");
	
	}
	
	 @Test(priority = 2)
	    public void testGetCreatedOrder() {
	        given().when()
	                .log()
	                .all()
	                .header("Authorization", "0f9e9fb043905072793dcf86dbe985b0cf2798dde153cd2b51004676d0284f80")
	                .get("https://simple-books-api.glitch.me/orders/" +this.orderId)
	                .then()
	                .log().all()
	                .assertThat().body("customerName", equalTo("Nada"))
	                			 .body("bookId",equalTo(1))
	                .statusCode(200);
	    }
	 @Test(priority = 3)
	    public void testUpdateOrder() {
		 
		 JSONObject request=new JSONObject();
		 request.put("customerName","Nada Mohamed");
	        given().when()
	                .log()
	                .all()
	                .header("Authorization", "0f9e9fb043905072793dcf86dbe985b0cf2798dde153cd2b51004676d0284f80")
	                .body(request.toString())
	                .patch("https://simple-books-api.glitch.me/orders/" +this.orderId)
	                .then()
	                .log().all()
	                .statusCode(204);
	    }
	 @Test(priority = 4)
	    public void testDeleteOrder() {
	        	 given()
	        		.when()
	                .header("Authorization", "0f9e9fb043905072793dcf86dbe985b0cf2798dde153cd2b51004676d0284f80")
	                .delete("https://simple-books-api.glitch.me/orders/" +this.orderId)
	                .then()
	                .statusCode(204);
	    }
}
