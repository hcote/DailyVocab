package com.company;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class DataRequest {

    /**
     * sets up a client and makes API request
     * @return response which is a json object converted to a string so that
     * it can easily be passed into the next function parseJsonForWord to extract
     * more specific data we're after
     */
    public static String getWordObject() {

        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://od-api.oxforddictionaries.com/api/v1/entries/en/nepotism"))
                    .headers("Content-Type", "application/json",
                            "app_id", "67c20362",
                            "app_key", "d236967a63ee1cc355c92f37bf3cfcff")
                    .build();
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body().toString());

            return response.body().toString();

        } catch (Throwable e) {
            e.printStackTrace();
        }

        return "Error attempting API Request. Try again.";
    }

    /**
     * This fn takes in @param jsonString, the Http response object converted to
     * a string from the getWord() method
     *
     * Using the org.json library I have access to JSONObject, JSONArray and other helpful
     * methods that allow me to parse the @param jsonString for what values I want
     *
     * @return
     */

    public static String parseJsonForWord(String jsonString) {

        try {

            JSONObject json = new JSONObject(jsonString);
            JSONArray results = json.getJSONArray("results");
            JSONObject first = results.getJSONObject(0);
            String word = first.getString("id"); // returns word i.e. nepotism
            System.out.println(word);

            return word;

        } catch (Throwable e) {
            e.printStackTrace();
        }

        return null;
    }

}
