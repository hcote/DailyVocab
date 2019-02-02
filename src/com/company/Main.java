package com.company;

import static com.company.DataRequest.getWordData;
import static com.company.DataRequest.parseJsonForWord;
import static com.company.SmsSender.sendText;

public class Main {

    public static void main(String[] args) {

        String json = getWordData(); // makes API call returns json.toString() response
        String word = parseJsonForWord(json); // parses response & returns single word
        sendText(word); // sends text with the word

    }
}
