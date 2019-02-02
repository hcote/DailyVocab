package com.company;

/**
 * This will be the structure for the data that will be serialized
 * from the API responses and sent to the application users.
 *
 *
 */

public class TextDataPOJO {

    private String word;
    private String partOfSpeech;
    private String definition;
    private String sentence;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
    
}
