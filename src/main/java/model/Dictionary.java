package model;


import java.util.HashMap;

public class Dictionary {

    // Task 1:
    private HashMap<String, String> words = new HashMap<>();


    // Task 2:
    // Method to add a new word and its meaning to the dictionary
    public void addWord(@org.jetbrains.annotations.NotNull String word, String wordMeaning) {
        words.put(word.toLowerCase(), wordMeaning);
    }

    // Method to get the meaning of a word
    public String getMeaning(String word) throws Exception  {
        if (words.containsKey(word)) {
            return words.get(word);

        } else {
            // If the word or meaning is not found in the Hashmap List, throw an exception
            throw new Exception("Word not found in dictionary");
        }
    }
}
