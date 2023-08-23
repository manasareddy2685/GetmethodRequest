package Test;

import static io.restassured.RestAssured.baseURI;
import org.testng.annotations.BeforeSuite;

import java.net.URL;

public class TestBase {

    @BeforeSuite
    public static void setup() { baseURI = "https://petstore.swagger.io/v2/pet/findByStatus"; }
}

