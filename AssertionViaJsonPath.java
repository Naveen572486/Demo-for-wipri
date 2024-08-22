//  M.Naveen
//  writing a program Assertion via Jsonpath
//  20 August 2024


package JsonPath;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AssertionViaJsonPath {
	 @Test (priority = 1)
	  public void jsonPathAssertions() {
		 
	 
		 System.out.println("\n****** Assertion via JsonPath ******");
		  
		  baseURI = "https://api.vschool.io/%5byour_name%5d/todo";
		  
		 Response response = 
		  given()
	         .pathParam("Book-Id","64c3b67a78fe452c1149d548")  

	     .when()
	        .get("/{Book-Id}")
	      .then()
	           .statusCode(200)
	           .extract().response();
		 
		 JsonPath jsonPath = response.jsonPath();
		 
		 String bookTitle = jsonPath.getString("title");
		 System.out.println("Book Title: "+ bookTitle);
		 int bookPrice = jsonPath.getInt("price");
		 System.out.println("Book Price :" +bookPrice);
		 boolean bookcompleted = jsonPath.getBoolean("completed");
		 System.out.println("completed :" +bookcompleted);
	 }
	 
	 @Test (priority = 2)
	  public void assertionForNthObject() {
		 
	 
		 System.out.println("\n****** Assertion via JsonPath ******");
		  
		  baseURI = "https://api.vschool.io/%5byour_name%5d/todo";
		  
		 Response response = 
		  given()
	     
	     .when()
	        .get()
	      .then()
	           .statusCode(200)
	           .extract().response();
		 
		 JsonPath jsonPath = response.jsonPath();
		 
		 String bookTitle = jsonPath.getString("[0].title");
		 System.out.println("Book Title: " +bookTitle);
		 int bookPrice = jsonPath.getInt("[1].price");
		 System.out.println("Book Price :" +bookPrice);
		 boolean bookcompleted = jsonPath.getBoolean("[0].completed");
		 System.out.println("completed :" +bookcompleted);
	 }
}
  
