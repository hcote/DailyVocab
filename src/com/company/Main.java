package com.company;

import java.util.Timer;

import static com.company.DataRequest.*;
import static com.company.SmsSender.sendText;

public class Main {

    public static void main(String[] args) {

        String json = getWordObject(); // makes API call returns json.toString() response
        String word = parseJsonForWord(json); // parses response & returns single word
        sendText(word); // sends text with the word

//        Timer timer = new Timer();
//        Test test = new Test();
//        timer.scheduleAtFixedRate(test, 0, 10000);

    }

}
