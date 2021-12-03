package com.essohpee.agecalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;

public class AgeCalculatorController implements Initializable {

    @FXML
    private Label daysLabel;
    @FXML
    private Label monthLabel;
    @FXML
    private Label yearLabel;
    @FXML
    private DatePicker dateOfBirthPicker;
    @FXML
    private DatePicker currentDatePicker;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currentDatePicker.setValue(LocalDate.now());

    }

    @FXML
    private void CalcAction(ActionEvent event) {
        try {
            LocalDate birthDate = dateOfBirthPicker.getValue();
            LocalDate currentDate = currentDatePicker.getValue();
            Period period = Period.between(birthDate, currentDate);
            if (period.getDays() < 0) {
                showErrorAlert();
                resetData();
                return;
            }
            daysLabel.setText(String.valueOf(period.getDays()));
            monthLabel.setText(String.valueOf(period.getMonths()));
            yearLabel.setText(String.valueOf(period.getYears()));
        } catch (Exception e) {
            showErrorAlert();
            resetData();
        }
    }

    private void showErrorAlert() {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setHeaderText("Enter Correct Date !");
        a.showAndWait();
    }

    private void resetData() {
        daysLabel.setText("");
        monthLabel.setText("");
        yearLabel.setText("");
    }
}