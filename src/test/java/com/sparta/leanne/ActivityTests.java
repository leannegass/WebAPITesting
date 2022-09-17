package com.sparta.leanne;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Service Object Model = connecting, creating the DTO, move DTO
//pojo field constructors setter getts no
public class ActivityTests {
    private static final String BASE_URL = "http://www.boredapi.com/api/activity/";
    private static ActivityPojo activityPojo;
    private static HttpResponse<String> httpResponse;
    @BeforeAll
    static void init() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .uri(URI.create(BASE_URL))
                .build();
        httpResponse = null;
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            activityPojo = objectMapper.readValue(new URL(BASE_URL), ActivityPojo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Nested
    @DisplayName("Check status code and headers")
    class CheckStatusCodeAndHeaders {
        @Test
        @DisplayName("Check status code")
        void checkStatusCode() {
            assertEquals(200, httpResponse.statusCode());
        }
        @Test
        @DisplayName("Simple header test")
        void simpleHeaderTest() {
            //Note how we have to deal with the Optional :(
            assertEquals("Cowboy", httpResponse.headers().firstValue("server").get());
        }



        @Test
        @DisplayName("Check uri")
        void checkUri() {
            assertEquals("http://www.boredapi.com/api/activity/", httpResponse.uri().toString());
        }
    }

    @Nested
    @DisplayName("Check for valid types")
    class CheckForValidTypes {
        @Test
        @DisplayName("Check that activity is not null")
        void checkThatActivityIsNotNull() {
            Assertions.assertNotNull(activityPojo.getActivity());
        }
        @Test
        @DisplayName("Check that there 0 to n participants")
        void checkThatThereIsAtLeastOneParticipantForAnActivity() {
            Assertions.assertTrue(activityPojo.getParticipants() >= 0);
        }
        @Test
        @DisplayName("Check that the key is always seven digits")
        void checkThatTheKeyIsAlwaysSevenDigits() {
            assertEquals(7, activityPojo.getKey().length());
        }
        @Test
        @DisplayName("Check that the price is from 0 to 1")
        void checkThatThePriceIsZeroToOne() {
            Assertions.assertTrue(activityPojo.getPrice()>=0 && activityPojo.getPrice()<=1 );
        }
    }


}

}
