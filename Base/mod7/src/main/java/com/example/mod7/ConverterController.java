package com.example.mod7;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ConverterController {
    @FXML
    private TextField inputField;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Label resultLabel;

    private static final double MILES_TO_KM = 1.60934;
    private static final double KM_TO_MILES = 0.621371;

    @FXML
    private void initialize() {
        choiceBox.getItems().addAll("Мили в километры", "Километры в мили");
        choiceBox.setValue("Мили в километры");
    }

    @FXML
    private void convert() {
        String value = inputField.getText();
        if (!value.isEmpty()) {
            double inputValue = Double.parseDouble(value);
            String choice = choiceBox.getValue();
            double result;
            String resultUnit;
            if (choice.equals("Мили в километры")) {
                result = inputValue * MILES_TO_KM;
                resultUnit = "км";
            } else {
                result = inputValue * KM_TO_MILES;
                resultUnit = "миль";
            }
            resultLabel.setText(String.format("%.2f %s", result, resultUnit));
        }
    }
}