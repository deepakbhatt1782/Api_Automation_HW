package Weather;

import com.beust.ah.A;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class WeatherApi {
    public static Response response;
    public static String jsonAsString;
    @BeforeMethod
    public static void setUp() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
    }
    @Test
    public void it_should_get_weather_by_id(){
        Response response = given()
                .basePath("users")
                .when()
                .get("2")
                .then()
                .extract()
                .response();

        Assert.assertEquals(response.getStatusCode(),200);
        jsonAsString = response.asString();
        System.out.println(jsonAsString);
        Assert.assertTrue(jsonAsString.contains("\"geo\": {\n" +
                "      \"lat\": \"-43.9509\",\n" +
                "      \"lng\": \"-34.4618\"\n" +
                "    }"));
    }
}
