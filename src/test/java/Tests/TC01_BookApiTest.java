package Tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.ResponseBody;

public class TC01_BookApiTest {
	
	ExtentReports extentReports=new ExtentReports();
	ExtentSparkReporter spark =new ExtentSparkReporter("target/Report/report.html");
	ExtentTest test;
	@BeforeTest
	public void report() {
		spark.config().setDocumentTitle("Api rest assured Report");
		spark.config().setTheme(Theme.DARK);
		extentReports.attachReporter(spark);
	}
	@Test
	public void GetBooklst()
	{
		ExtentTest test = extentReports.createTest("Verify that all books are displayed");
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
					test.log(Status.PASS,"Test passed");
	}
	@Test
	public void GetSpecificBook()
	{
		ExtentTest test = extentReports.createTest("Verify that user will be able to see book details");
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
	@AfterTest
	public void teardown()
	{
		extentReports.flush();
	}
}
