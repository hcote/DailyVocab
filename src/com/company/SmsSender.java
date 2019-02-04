package com.company;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.ArrayList;

public class SmsSender {

    static ArrayList<String> phoneNumbers = new ArrayList<>();

    static {
        phoneNumbers.add("+1xxxxxxxxxx");
        phoneNumbers.add("+1xxxxxxxxxx");
    }



    public static final String ACCOUNT_SID =
            "AC8a1932cdb890753332c3d14dbb8c7ec3";
    public static final String AUTH_TOKEN =
            "d2fbf1ab99f9b3fb96c0e8774ea3e142";

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
