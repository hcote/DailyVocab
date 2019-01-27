package com.company;

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
            System.out.println(response.body());
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

}
