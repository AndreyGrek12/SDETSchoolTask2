package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static tests.Methods.findUserByName;

public class APITest{

    @Test
    @Description ("Проверка соответсвия пользователя и его email")
    public void apiTest () {
        Assert.assertEquals(findUserByName("George", "Bluth"), "[george.bluth@reqres.in]", "email не совпадает");
    }

    @Test
    @Description ("Проверка соответсвия пользователя и его email с пагинацией")
    public void paginationApiTest () {
        Assert.assertEquals(findUserByName("Michael", "Lawson"), "[michael.lawson@reqres.in]", "email не совпадает");
    }
}
