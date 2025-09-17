package controller;


import model.Dictionary;

public class DictionaryController {

    private Dictionary dictionary;


    public DictionaryController() {

        // Dictionary Class
        dictionary = new Dictionary();

        // Adding some sample words to the dictionary
        dictionary.addWord("example", "a representative form or pattern");
        dictionary.addWord("java", "a high-level programming language");
        dictionary.addWord("python", "a python programming language");
    }

    // Method to search for a word in the dictionary and return its meaning from the "Model" class
    public String searchWord(String word) {
        try {
            return dictionary.getMeaning(word);
        } catch (Exception e) {
            return "Word not found: " + word;
        }
    }
}

