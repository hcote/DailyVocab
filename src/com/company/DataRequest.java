package com.company;

import org.json.simple.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DataRequest {

    public static void getVocabData() {

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://od-api.oxforddictionaries.com/api/v1/entries/en/nepotism"))
                    .headers("Content-Type", "application/json",
                            "app_id", "67c20362",
                            "app_key", "d236967a63ee1cc355c92f37bf3cfcff")
                    .build();
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            /**
             * JSONObject obj = new JSONObject(response.body());
             * This line of code doesn't work because JSONObject needs
             * a Map and response.body() is an Object
             */

            System.out.println();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
