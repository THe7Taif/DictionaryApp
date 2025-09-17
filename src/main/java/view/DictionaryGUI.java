package view;

import controller.DictionaryController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.stage.Stage;

public class DictionaryGUI extends Application {

    private DictionaryController controller;

    @Override
    public void init() {
        controller = new DictionaryController();
    }

    @Override
    public void start(Stage stage) {

        // Input field
        TextField wordInput = new TextField();
        wordInput.setPromptText("🔎 Enter a word");
        wordInput.setMaxWidth(250);

        // Result label
        VBox layout = getVBox(wordInput);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: rgba(47, 79, 79); ");

        // Scene with CSS
        Scene scene = new Scene(layout, 450, 220);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setTitle("Dictionary");
        stage.setScene(scene);
        stage.show();
    }

    private VBox getVBox(TextField wordInput) {
        Label resultLabel = new Label("Meaning will appear here");
        resultLabel.setWrapText(true);
        resultLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: white;");

        // Search button
        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> {
            String word = wordInput.getText().trim();
            if (word.isEmpty()) {
                resultLabel.setText("Please enter a word!");
            } else {
                String meaning = controller.searchWord(word);
                resultLabel.setText(meaning);
            }
        });

        // Layout
        VBox layout = new VBox(15, wordInput, searchButton, resultLabel);
        return layout;
    }
}
