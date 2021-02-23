package sample;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller {

    @FXML TextField username_section;
    @FXML TextField password_section;
    @FXML TextField full_name_section;
    @FXML TextField email_section;
    @FXML TextField phone_number_section;
    @FXML DatePicker DOB_section;

    public void handleSubmitButtonAction(ActionEvent actionEvent) {
        System.out.println("Username: " + username_section.getText());
        System.out.println("Password: " + password_section.getText());
        System.out.println("Full name: " + full_name_section.getText());
        System.out.println("Email: " + email_section.getText());
        System.out.println("Phone number: " + phone_number_section.getText());
        System.out.println("Date of birth: " + DOB_section.getValue().toString());
    }
}