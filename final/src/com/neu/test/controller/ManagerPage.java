package com.neu.test.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ManagerPage implements Initializable {
    public Button manage_emp;
    public Button manage_qust;
    public Button manage_paper;
    public Button manage_building;
    public Button manage_p;
    public Button more;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void to_manage_emp(ActionEvent actionEvent) {
        try {
            Stage tempst=(Stage)
                    more.getScene().getWindow();
            tempst.close();
            Parent emp_page= FXMLLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/com/neu/test/fxml/emp_page.fxml")));
            Stage emp_s=new Stage();
            emp_s.setTitle("emp page");
            emp_s.setScene(new Scene(emp_page));
            emp_s.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void to_qust(ActionEvent actionEvent) {
        try {
            Stage tempst=(Stage)
                    more.getScene().getWindow();
            tempst.close();
            Parent emp_page= FXMLLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/com/neu/test/fxml/emp_quest.fxml")));
            Stage emp_s=new Stage();
            emp_s.setTitle("question page");
            emp_s.setScene(new Scene(emp_page));
            emp_s.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void to_paper(ActionEvent actionEvent) {
        try {
            Stage tempst=(Stage)
                    more.getScene().getWindow();
            tempst.close();
            Parent emp_page= FXMLLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/com/neu/test/fxml/paper_page.fxml")));
            Stage emp_s=new Stage();
            emp_s.setTitle("paper_page");
            emp_s.setScene(new Scene(emp_page));
            emp_s.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void to_building(ActionEvent actionEvent) {
    }

    public void to_p(ActionEvent actionEvent) {
        try {
            Stage tempst=(Stage)
                    more.getScene().getWindow();
            tempst.close();
            Parent emp_page= FXMLLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/com/neu/test/fxml/patient_page.fxml")));
            Stage emp_s=new Stage();
            emp_s.setTitle("patient_page");
            emp_s.setScene(new Scene(emp_page));
            emp_s.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void to_more(ActionEvent actionEvent) {
    }
}
