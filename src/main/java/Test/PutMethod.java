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

public class PutMethod extends TestBase{
    @Test(groups = "PUT")
    public  void updatePet()  {
        PetCategory petCategory = new PetCategory();

        petCategory.setId(1);
        petCategory.setName("pet1");
        petCategory.setName("updatepet1");

        PetTags petTags1 = new PetTags();
        PetTags petTags2 = new PetTags();
        petTags1.setId(3);
        petTags1.setName("petTags1");
        petTags2.setId(4);
        petTags2.setName("petTags2");

        List<PetTags> petTags = new ArrayList<>();
        petTags.add(petTags1);
        petTags.add(petTags2);

        List<String> PhotoUrls = new ArrayList<>();
        PhotoUrls.add("testurl");

        Pet pet = new Pet();

        pet.setId(1);

        pet.setCategory(petCategory);
        pet.setName("petname");
        pet.setPhotoUrls(PhotoUrls);
        pet.setTags(petTags);
        pet.setStatus("pending");

        String requestObject = GsontoJSON.convertToJSON(pet);

        Response response = PutRequest("https://petstore.swagger.io/v2/pet", requestObject);
        System.out.println("json-body post request is" + requestObject);
        Assert.assertEquals(response.statusCode(), 200);


    }
    public Response PutRequest(String url, String requestBody) {

        Response response = given()
                .contentType(ContentType.JSON)
                .and()
                .body(requestBody)
                .when()
                .post(url)
                .then()
                .extract().response();

        return response;
    }
}

