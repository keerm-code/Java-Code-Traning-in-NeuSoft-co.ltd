package com.neu.test.controller;

import com.neu.test.pojo.impl.Employee;
import com.neu.test.service.impl.Service;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Login implements Initializable {
    @FXML
    public Button login_b;
    @FXML
    public TextField name;
    @FXML
    public TextField key;
    @FXML
    public Button sign_b;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //nothing in it ,but it will work
    }

    @FXML
    public void login(ActionEvent actionEvent) {
        Employee login_em=new Employee(name.getText(),key.getText());
        try {
            login_em=Service.getInstance().login(login_em);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(login_em==null)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("init fail");
            alert.setContentText("system cannot init,maybe datafile is broken");
            alert.showAndWait();
            Stage tempst=(Stage)
                    sign_b.getScene().getWindow();
            tempst.close();
            return;
        }
        if(login_em.getType().equals("manager"))
        {
            try {
                Stage tempst=(Stage)
                sign_b.getScene().getWindow();
                tempst.close();
                Parent manager_page=FXMLLoader.load(Objects.requireNonNull(getClass()
                        .getResource("/com/neu/test/fxml/manager_page.fxml")));
                Stage manager_s=new Stage();
                manager_s.setTitle("manager page");
                manager_s.setScene(new Scene(manager_page));
                manager_s.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(login_em.getType().equals("doctor"))
        {
            try {
                Stage tempst=(Stage)
                        sign_b.getScene().getWindow();
                tempst.close();
                Parent doctor_page=FXMLLoader.load(Objects.requireNonNull(getClass()
                        .getResource("/com/neu/test/fxml/doctor_page.fxml")));
                Stage doctor_s=new Stage();
                doctor_s.setTitle("doctor page");
                doctor_s.setScene(new Scene(doctor_page));
                doctor_s.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(login_em.getType().equals("nurse"))
        {
            try {
                Stage tempst=(Stage)
                        sign_b.getScene().getWindow();
                tempst.close();
                Parent nurse_page=FXMLLoader.load(Objects.requireNonNull(getClass()
                        .getResource("/com/neu/test/fxml/nurse_page.fxml")));
                Stage nurse_s=new Stage();
                nurse_s.setTitle("nurse page");
                nurse_s.setScene(new Scene(nurse_page));
                nurse_s.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(login_em.getType().equals("worker"))
        {
            try {
                Stage tempst=(Stage)
                        sign_b.getScene().getWindow();
                tempst.close();
                Parent worker_page=FXMLLoader.load(Objects.requireNonNull(getClass()
                        .getResource("/com/neu/test/fxml/worker_page.fxml")));
                Stage worker_s=new Stage();
                worker_s.setTitle("worker page");
                worker_s.setScene(new Scene(worker_page));
                worker_s.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            Stage tempst=(Stage)
                    sign_b.getScene().getWindow();
            tempst.close();
            tempst.show();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("login fail");
//            alert.setHeaderText();
            alert.setContentText("Your password is wrong or your account's information is broken" +
                    "\nplease try again");

            alert.showAndWait();
        }

    }

    @FXML
    public void signup(ActionEvent actionEvent) {
        Stage signup_s=new Stage();
        signup_s.setTitle("sign up");
        Parent sign_root = null;
        try {
             sign_root= FXMLLoader.load(Objects.requireNonNull(getClass()
                    .getResource("signin.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        signup_s.setScene(new Scene(sign_root));
        signup_s.show();
    }
}
