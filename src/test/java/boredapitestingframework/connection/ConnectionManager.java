package boredapitestingframework.connection;

//responsible for creating a connection to the endpoint

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectionManager {
    private static final  String BASEURL = "https://swapi.dev/api/people/";

    public static String getConnection(){
        return BASEURL;
    }

    public static String getConnection(String key, String value){

        return  BASEURL + "?" + key + "=" + value;
    }

    public static String getConnection(String key, int value){

        return  BASEURL + "?" + key + "=" + value;
    }

    private static HttpResponse<String> getResponse(){
        var client  = HttpClient.newHttpClient();
        var request = HttpRequest
                .newBuilder()
                .uri(URI.create(BASEURL))
                .build();
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response);
        return response;


    }
    public static int getStatusCode(){
        return getResponse().statusCode();
    }

    public static String getHeader(String key){
        return getResponse()
                .headers()
                .firstValue(key)
                .orElse("Key not found");
    }

}















