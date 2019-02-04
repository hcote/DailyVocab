package com.company;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.company.SensitiveInfo.*;

import java.util.ArrayList;

public class SmsSender {

    static ArrayList<String> phoneNumbers = new ArrayList<>();

    /**
     * this allows us to add the numbers to the array list without
     * creating and calling a method to do so for us
     */

    static {
        phoneNumbers.add(jsNum);
        phoneNumbers.add(myNum);
    }



    public static final String ACCOUNT_SID =
            accoundSid;
    public static final String AUTH_TOKEN =
            authToken;

    public static void sendText(String textBody) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        for(String number : phoneNumbers) {
            Message message = Message
                    .creator(new PhoneNumber(number), // to
                            new PhoneNumber("+14152002382"), // from
                            textBody)
                    .create();
        }

        System.out.println("Messages sent!");
    }

}
