package com.sparta.leanne;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RestAssuredTests {
    @Test
    @DisplayName(("Check status code is 200"))
    void checkStatusCodeOfWebsites(){
        RestAssured.get("https://www.spartaglobal.com")
                .then()
                .assertThat()
                .statusCode(200);
    }


}
