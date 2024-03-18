package com.example.pt2024_30229_caraba_marian_assignment_1;

import polynomialPackage.Operations;
import polynomialPackage.Polynomial;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class HelloController {

    @FXML
    private Button addition;

    @FXML
    private Button subtraction;

    @FXML
    private Button derivation;

    @FXML
    private Button division;

    @FXML
    private TextField firstPolInput;

    @FXML
    private Button integration;

    @FXML
    private Button multiplication;

    @FXML
    private TextField secondPolInput;

    @FXML
    private TextField resultOutput;

    public void control (ActionEvent event) {
        if(event.getSource() == addition) {
            Polynomial polynomial1 = Operations.stringToPolynomial(firstPolInput.getText());
            Polynomial polynomial2 = Operations.stringToPolynomial(secondPolInput.getText());

            Polynomial result = Operations.add(polynomial1, polynomial2);
            resultOutput.setText(result.toString());
        }

        if(event.getSource() == subtraction) {
            Polynomial polynomial1 = Operations.stringToPolynomial(firstPolInput.getText());
            Polynomial polynomial2 = Operations.stringToPolynomial(secondPolInput.getText());

            Polynomial result = Operations.subtract(polynomial1, polynomial2);
            resultOutput.setText(result.toString());
        }

        if(event.getSource() == multiplication) {
            Polynomial polynomial1 = Operations.stringToPolynomial(firstPolInput.getText());
            Polynomial polynomial2 = Operations.stringToPolynomial(secondPolInput.getText());

            Polynomial result = Operations.multiply(polynomial1, polynomial2);
            resultOutput.setText(result.toString());
        }

        if(event.getSource() == division) {
            Polynomial polynomial1 = Operations.stringToPolynomial(firstPolInput.getText());
            Polynomial polynomial2 = Operations.stringToPolynomial(secondPolInput.getText());

            ArrayList<Polynomial> result = Operations.divide(polynomial1, polynomial2);
            resultOutput.setText("q: ( " + result.get(0).toString() + " )" + ", r: " + result.get(1));
        }

        if(event.getSource() == derivation) {
            Polynomial polynomial1 = Operations.stringToPolynomial(firstPolInput.getText());

            Polynomial result = Operations.derive(polynomial1);
            resultOutput.setText(result.toString());
        }

        if(event.getSource() == integration) {
            Polynomial polynomial1 = Operations.stringToPolynomial(firstPolInput.getText());

            Polynomial result = Operations.integrate(polynomial1);
            resultOutput.setText(result.toString());
        }
    }

}
