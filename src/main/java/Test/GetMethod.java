package Test;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

public class GetMethod extends TestBase {
    @Test(groups = "GET")
    public void GetRequest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .param("status", "available")
                .when()
                .get("https://petstore.swagger.io/v2/store/order/1")
                .then()
                .extract().response();


        System.out.println("Response is:" + response);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(groups = "GET")
    public void GetResponseStatus() {
        int statusCode = given().param("status", "available")
                .contentType(ContentType.JSON)
                .when().get("https://petstore.swagger.io/v2/pet/findByStatus").getStatusCode();
        System.out.println("The response status is " + statusCode);
        given().when().get("https://petstore.swagger.io/v2/pet/findByStatus").then().assertThat().statusCode(200);
    }


    @Test(groups = "GET")
    public void GetResponseBody(){
        given()
                .when()
                .get("https://petstore.swagger.io/#/pet/findPetsByStatus")
                .then()
                .log()
                .all();
             given().queryParam("status", "available")
                .when().get("https://petstore.swagger.io/#/pet/findPetsByStatus").then().log().body();
    }

    @Test(groups = "GET")
    public  void GetResponseHeaders() {
        System.out.println("the headers in the response" +
                get("https://petstore.swagger.io/v2/pet/findByStatus").then().extract().headers());

    }


    @Test(groups = "GET")
    public static void GetResponseContentType() {
        System.out.println("the content in the response" +
                get("https://petstore.swagger.io/v2/pet/findByStatus").then().extract().contentType());

    }

    @Test(groups = "GET")
    public void GetResponseTime() {
        System.out.println("the time taken to fetch the response" +
                get("https://petstore.swagger.io/v2/pet/findByStatus").timeIn(TimeUnit.MILLISECONDS) + "milliseconds");
    }
    @Test(groups = "GET")
    public void GetPetAllStatus(){
        List<String> petStatus = new ArrayList<String>();
        petStatus.add("available");
        petStatus.add("sold");
        petStatus.add("pending");

        int l = petStatus.size();
        String petStatusInput ="";
        for (int i = 0; i<l;i++){
            petStatusInput += "status="+ petStatus.get(i)+"&" ;

        }
        System.out.println(petStatusInput);
        Response response = GetRequestBody("https://petstore.swagger.io/#/pet/findPetsByStatus" ,petStatusInput);
    }
          public Response GetRequestBody(String url,String petStatusInput){
          Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(url+"?"+petStatusInput)
                .then()
                .extract().response();
          return response;
    }

}



