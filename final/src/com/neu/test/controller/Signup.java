package com.neu.test.controller;

import com.neu.test.pojo.impl.Employee;
import com.neu.test.service.impl.Service;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Signup implements Initializable {
    @FXML
    public TextField name;
    @FXML
    public Button sign_b;
    @FXML
    public TextField key;
    @FXML
    public ChoiceBox<String> type;//=new ChoiceBox(FXCollections.observableArrayList("manager","doctor","nurse","worker"));


    public void sign(ActionEvent actionEvent) {
        Employee em=new Employee(name.getText(),key.getText(),type.getValue());
        System.out.println(em);
        if(Service.getInstance().signin(em))
        {
            Stage sign_s=(Stage)
                    sign_b.getScene().getWindow();
            sign_s.close();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("login fail");
//            alert.setHeaderText();
            alert.setContentText("This account has signed");

            alert.showAndWait();
        }
        Stage sign_s=(Stage)
        sign_b.getScene().getWindow();
        sign_s.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        type.getItems().add("manager");
        type.getItems().add("nurse");
        type.getItems().add("doctor");
        type.getItems().add("worker");
    }
}
