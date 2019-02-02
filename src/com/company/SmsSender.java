package com.company;

// Install the Java helper library from twilio.com/docs/libraries/java
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "AC8a1932cdb890753332c3d14dbb8c7ec3";
    public static final String AUTH_TOKEN =
            "d2fbf1ab99f9b3fb96c0e8774ea3e142";

    public static void sendText(String textBody) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+14017141831"), // to
                        new PhoneNumber("+14013204042"), // from
                        textBody)
                .create();

        System.out.println(message.getSid());
    }
}
