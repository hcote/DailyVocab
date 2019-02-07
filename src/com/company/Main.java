package com.company;

import java.util.Timer;

import static com.company.DataRequest.*;
import static com.company.SmsSender.sendText;

public class Main {

    public static void main(String[] args) {

        // makes API call returns json.toString() response
        String json = getWordObject();

        //parses response & returns the word, definition and sentence
        // which will compose the text message the end user receives
        String text = parseJsonForWord(json);

        // sends text with the word, definition and sentence
        sendText(text);

//        Timer timer = new Timer();
//        Test test = new Test();
//        timer.scheduleAtFixedRate(test, 0, 15000);

    }

}
