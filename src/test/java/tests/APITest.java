package tests;

import io.qameta.allure.Description;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest extends Methods{

    private RequestSpecification requestSpecification;

    @BeforeMethod
    public void requestSpecification () {
         requestSpecification = given()
                .baseUri("https://reqres.in/api/")
                .contentType(ContentType.JSON);
    }

    @Test
    @Description ("Проверка соответсвия пользователя и его email")
    public void apiTest () {
        Assert.assertEquals(findUserByName("George", "Bluth", requestSpecification), "[george.bluth@reqres.in]", "email не совпадает");
    }

    @Test
    @Description ("Проверка соответсвия пользователя и его email")
    public void paginationApiTest () {
        Assert.assertEquals(findUserByName("Michael", "Lawson", requestSpecification), "[michael.lawson@reqres.in]", "email не совпадает");
    }
}
