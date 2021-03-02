package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    @FXML TableView<StudentRecord> tableView;
    @FXML TableColumn student_ID;
    @FXML TableColumn midterm;
    @FXML TableColumn assignments;
    @FXML TableColumn final_exam;
    @FXML TableColumn final_mark;
    @FXML TableColumn letter_grade;

    @FXML
    public void initialize() {
        student_ID.setCellValueFactory(new PropertyValueFactory<>("student_ID"));
        midterm.setCellValueFactory(new PropertyValueFactory<>("midterm"));
        assignments.setCellValueFactory(new PropertyValueFactory<>("assignments"));
        final_exam.setCellValueFactory(new PropertyValueFactory<>("final_exam"));
        final_mark.setCellValueFactory(new PropertyValueFactory<>("final_mark"));
        letter_grade.setCellValueFactory(new PropertyValueFactory<>("letter_grade"));

        tableView.setItems(DataSource.getAllMarks());
    }

}

