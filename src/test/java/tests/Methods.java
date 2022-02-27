package tests;

import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;



public class Methods{



    public int getTotalPages (RequestSpecification reqSpec) {
        return reqSpec
                .when()
                .get("users")
                .then()
                .extract()
                .jsonPath()
                .getInt("total_pages");
    }


    @Step ("Поиск пользователя с именем {firstName} и фамилией {lastName}")
    public String findUserByName (String firstName, String lastName, RequestSpecification reqSpec) {
        String userEmail;
        int i = 1;
        do {
            userEmail = reqSpec
                    .queryParam("page",String.valueOf(i))
                    .when()
                    .get("users")
                    .then()
                    .extract()
                    .jsonPath()
                    .getString("data.findAll {data -> data.first_name == '" + firstName + "' && data.last_name == '" + lastName + "'}.email");
                    i++;
        }
        while (userEmail.equals("[]") && i<=getTotalPages(reqSpec));
        return userEmail;

    }
}
