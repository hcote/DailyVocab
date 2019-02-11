package com.company;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.company.hiddeninfo.SensitiveInfo.APIkey;


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
                    .uri(URI.create("https://api.wordnik.com/v4/words.json/wordOfTheDay?api_key=" + APIkey))
                    .header("Content-Type", "application/json")
                    .build();
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            return response.body().toString();

        } catch (Throwable e) {
            e.printStackTrace();
        }

        return "Error attempting API Request. Try again.";
    }

    /**
     * This method takes in @param jsonString, the Http response object converted to
     * a string from the getWord() method
     *
     * Using the org.json library I have access to JSONObject, JSONArray and other helpful
     * methods that allow me to parse the @param jsonString for what values I want
     *
     */

    public static String parseJsonForWord(String jsonString) {

        try {

            JSONObject json = new JSONObject(jsonString);
            String word = json.getString("word");
            JSONArray examples = json.getJSONArray("examples");
            JSONObject sentenceObj = examples.getJSONObject(0);
            String sentence = sentenceObj.getString("text");
            JSONArray definitions = json.getJSONArray("definitions");
            JSONObject definitionsObj = definitions.getJSONObject(0);
            String definition = definitionsObj.getString("text");

            return("Word: " + word + "\n\n"
                    + "Definition: " + definition + "\n\n"
                    + "Sentence: " + sentence + "\n\n"
                    + "Reply 'stop' to stop receiving these messages.");

        } catch (Throwable e) {
            e.printStackTrace();
        }

        return "Failed to attempt to parse json object";
    }

}
