package com.company;

import static com.company.DataRequest.getWord;
import static com.company.DataRequest.parseJsonForWord;

public class Main {

    public static void main(String[] args) {

        /**
         *
         * getWordObject();
         * only used to return http response object when it
         * contained `System.out.println(response.body();`
         *
         */

//        System.out.println(getWordObject());

        String word = getWord();
        parseJsonForWord(word);

    }
}
