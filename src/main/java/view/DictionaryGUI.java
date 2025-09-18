package view;

import controller.DictionaryController;
import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Insets;

public class DictionaryGUI extends Application {

    private DictionaryController controller;

    public void start(Stage stage) {

        /// GUI components (Button, TextField, Label, Spinner, etc.)

        // Step 1: TextField, Label, Button
        TextField wordInput = new TextField();            /// text field to enter the word to search
        wordInput.setPromptText("Enter word: ");          /// prompt text for the input field

        Label resultLabel = new Label("Meaning will be shown here");  /// label to display the result

        Button searchButton = new Button("Search word");            /// button to search for a word

        // Step 2: event handler for the button click event. When the button is clicked, it retrieves the word from the text field, calls the controller to search for the word, and updates the result label with the meaning.
        searchButton.setOnAction(e -> {
            String word = wordInput.getText().trim();
            if (word.isEmpty()) {
                resultLabel.setText("Please enter a word!");
            } else {
                String meaning = controller.searchWord(word);
                resultLabel.setText(meaning);
            }
        });

        // Step 3: Layout using FlowPane and adding components to it:
        FlowPane pane = new FlowPane(10, 10);                                     /// layout pane
        /// add outside margins for components
        pane.setPadding(new Insets(10, 10, 10, 10));         /// padding around the pane
        pane.getChildren().addAll(wordInput, searchButton, resultLabel);

        // Step 4: Initialize the controller and show the stage
        /// set the stage title, scene and show the stage
        stage.setScene(new javafx.scene.Scene(pane, 400, 150));
        stage.setTitle("Words Dictionary Finder");
        stage.show();
    }

    @Override
    public void init() {
        controller = new DictionaryController();  // Initialize the controller in the init method
    }

}