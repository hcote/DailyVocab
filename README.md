## Overview
This app integrates Twilio text messaging services and sends you a text every morning at 11am with a new vocabulary "word of the day". It makes a simple rest API call to the Wordnik developer portal.

## Technologies Used
1. Java
2. Twilio
3. Ngrok

## How It Works

### Sending texts
In Main.class there is a scheduled method to run at 11am each morning, which calls ChronJob.class
ChronJob's three methods are the core of the application. First is the API call which makes a simple HTTP request for data and returns a json object.
The second method parses the json data and extracts the word, definition and example sentence.
The third method is what sends the text message.

The third method makes use of Twilio's technology and builds a message of whatever parameter is passed through (the extracted word, definition and sentence mentioned above). It loops through an ArrayList of phone numbers and sends that text to each one (at 11am). 

### Receiving texts
This application is also capable of receiving texts
