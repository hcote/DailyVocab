package com.company;

//import org.json.*;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DataRequest {

    public static void getWordObject() {

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://od-api.oxforddictionaries.com/api/v1/entries/en/nepotism"))
                    .headers("Content-Type", "application/json",
                            "app_id", "67c20362",
                            "app_key", "d236967a63ee1cc355c92f37bf3cfcff")
                    .build();
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Object responseBody = response.body();

            System.out.println(responseBody);

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void extractSpecificWordData(Object wordObject) {

        /**
         * JSONObject obj = new JSONObject(wordObject);
         * This line of code doesn't work because JSONObject expects
         * a Map and wordObject is an Object
         *
         * ObjectMapper turns JSONObject to Map which needs to be imported through an external lib
         */

    }

}
