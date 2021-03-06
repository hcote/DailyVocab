## Overview
This app integrates Twilio text messaging services and Wordnik API to send you a text every morning with a new vocabulary "word of the day".
Text the word "start" to (415) 200-4846 to begin receiving daily vocab words in sms messages. They come in at 10am EST, 7am PST each morning.

## Update
I want this app to be used by many people and a hands-off, long-running project. The way it was originally set up with ngrok and a localhost server was not setting it up for that. I turned it into a maven project and uploaded the code to Heroku so now that is my server sending daily texts. To see that it is up and running just go to https://wordoftheday1.herokuapp.com/

## Update 2
Given the codebase for sending daily texts was already there, I refactored the API and now created another app that sends a daily inspirational quote. Just text (415) 200-2382 to start. This is also running on Heroku and you can go to https://quoteoftheday2.herokuapp.com/ to see that it is running.

## Technologies Used
1. Java 11
2. Maven
3. Twilio
4. Ngrok
5. Heroku

## How It Works

### Sending texts
In Main.class there is a scheduled method to run at 7am each morning, which calls ChronJob.class. ChronJob's three methods are the core of the application.
The first is the API call to Wordnik which is a simple HTTP request for data and returns a json object.
The second method parses the json data and extracts the word, definition and example sentence.
The third method is what sends the text message.

The third method makes use of Twilio's technology and builds a message of whatever parameter is passed through (the extracted word, definition and sentence mentioned above). It loops through an ArrayList of phone numbers and sends that text to each one (at 11am). 

### Receiving texts
This application is also capable of receiving texts (SmsApp.class) and is where ngrok comes in. I start a localhost server with the SmsApp.main() method. Next, with the command $ ./ ngrok 4567 (the port my localhost server is running on) I am given a unique nkgro.io URL where traffic to that URL is automatically forwarded to my local server. 

I instruct Twilio to send any POST requests (received text messages) to my ngrok URL which then get forwarded to my localhost server which then get handled however I specify in SmsApp.class. In that file, for POST requests, if a text comes in that says "enroll" then the user's phone number is added to the ArrayList and will start receiving daily texts and when they text "stop" they will be removed from the ArrayList and no longer receive texts. The image below taken from Twilio explains the process a POST request goes through. 

(when Twilio receives a request and sends an HTTP request to my server, this is called a webhook)
<img width="654" alt="screen shot 2019-02-07 at 6 16 08 pm" src="https://user-images.githubusercontent.com/34493689/52455893-29596280-2b07-11e9-87ee-43a6ceff3ca6.png">

image source: https://www.twilio.com/docs/sms/quickstart/java#receive-and-reply-to-inbound-sms-messages
