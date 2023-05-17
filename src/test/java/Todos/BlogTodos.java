package Todos;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BlogTodos {
    @BeforeMethod
    public static void setUp() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
    }
    @Test
    public void it_should_get_todos_by_id_2() {
        Response response = given()
                .basePath("todos")
                .when()
                .get("2")
                .then()
                .extract()
                .response();

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.jsonPath().getInt("userId"),1);
        Assert.assertEquals(response.jsonPath().getInt("id"),2);
        Assert.assertEquals(response.jsonPath().getString("title"),"quis ut nam facilis et officia qui");
        Assert.assertEquals(response.jsonPath().getString("completed"),"false");
        response.prettyPrint();
    }
    @Test
    public void it_should_get_todos_by_id_4(){

        Response response = given()
                .basePath("todos")
                .when()
                .get("4")
                .then()
                .extract()
                .response();

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.jsonPath().getInt("userId"),1);
        Assert.assertEquals(response.jsonPath().getInt("id"),4);
        Assert.assertEquals(response.jsonPath().getString("title"),"et porro tempora");
        Assert.assertEquals(response.jsonPath().getString("completed"),"true");
        response.prettyPrint();
    }
}
