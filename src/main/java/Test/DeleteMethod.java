package Test;
import datamodel.Pet;
import datamodel.PetCategory;
import datamodel.PetTags;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class DeleteMethod extends TestBase {


    @Test(groups = "DELETE")
    public void DeleteRequest() {

        Response response = given()

                .contentType(ContentType.JSON)
                .when()
                .delete("https://petstore.swagger.io/v2/pet/1")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200);

    }
}



