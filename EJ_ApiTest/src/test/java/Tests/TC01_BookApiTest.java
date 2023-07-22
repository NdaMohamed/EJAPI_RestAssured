package Tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.ResponseBody;

public class TC01_BookApiTest {
	 private String bookId;
	@Test
	public void GetBooklst()
	{
					given().when()
	                .log()
	                .all()
	                .contentType(ContentType.JSON)
	                .get("https://simple-books-api.glitch.me/books")
	                .then()
	                .log().all()
	                .statusCode(200)
	                .assertThat()
					.body("type",hasItems("fiction","non-fiction"));
		
	}
	@Test
	public void GetSpecificBook()
	{
		  given().when()
          .log()
          .all()
          .header("Authorization", "0f9e9fb043905072793dcf86dbe985b0cf2798dde153cd2b51004676d0284f80")
          .get("https://simple-books-api.glitch.me/books/" +5)
          .then()
          .log().all()
          .statusCode(200)
          .assertThat()
          .body("name",equalTo("Untamed"))
          .body("author",equalTo("Glennon Doyle"))
          .body("type",equalTo("non-fiction"))
          .body("available",equalTo(true));
	}
	
}
