package com.company;

import org.json.simple.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class DataRequest {

    public static Object getWordObject() {

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://od-api.oxforddictionaries.com/api/v1/entries/en/nepotism"))
                    .headers("Content-Type", "application/json",
                            "app_id", "67c20362",
                            "app_key", "d236967a63ee1cc355c92f37bf3cfcff")
                    .build();
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (Throwable e) {
            e.printStackTrace();
        }
        return returnObjectIfNoAttemptToGetWord;
    }

    public static Object parseJsonForWord(Object wordObject) {

        Map<String, Object> word = new HashMap<String, Object>();
        word.put("Response:", wordObject);
        JSONObject wordMap = new JSONObject(word);
        System.out.println(wordMap);

        return wordMap;
    }

    private static Object returnObjectIfNoAttemptToGetWord = "You did not get the word";

}
