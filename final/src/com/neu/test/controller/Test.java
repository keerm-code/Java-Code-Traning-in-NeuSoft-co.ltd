package com.neu.test.controller;

import com.neu.test.basetool.impl.Basetool;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Test implements Initializable {
    public Button finish;
    public ChoiceBox a1;
    public ChoiceBox a3;
    public ChoiceBox a2;
    public ChoiceBox a4;
    public ChoiceBox a5;
    public Label l1;
    public Label l2;
    public Label l3;
    public Label l4;
    public Label l5;
    List<Label> ls;
    List<ChoiceBox<String>> boxList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ls=new ArrayList<Label>(Arrays.asList(new Label[]{l1, l2, l3, l4, l5}));
        boxList=new ArrayList<ChoiceBox<String>>();
        boxList.add(a1);
        boxList.add(a2);
        boxList.add(a3);
        boxList.add(a4);
        boxList.add(a5);
        for(int i=0;i<5&&i<Basetool.get_chosen_paper().getQuestions().size();i++)
        {
            if(Basetool.get_chosen_paper().getQuestions()!=null)
            {
                ls.get(i).setText(Basetool.get_chosen_paper().getQuestions().get(i).getName());
                boxList.get(i).getItems().add(Basetool.get_chosen_paper().getQuestions().get(i).getAnswer1());
                boxList.get(i).getItems().add(Basetool.get_chosen_paper().getQuestions().get(i).getAnswer2());
                boxList.get(i).getItems().add(Basetool.get_chosen_paper().getQuestions().get(i).getAnswer3());
            }
            else {
                ls.get(i).setText("");
            }
        }
    }

    public void finish(ActionEvent actionEvent) {
        int result=0;
        for(int i=0;i<5;i++)
        {
            if(boxList.get(i).getValue()==null)
            {
                continue;
            }
            if(boxList.get(i).getValue().equals(Basetool.get_chosen_paper().getQuestions().get(i).getAnswer1()))
            {
                result=result+5;
            }
            else if(boxList.get(i).getValue().equals(Basetool.get_chosen_paper().getQuestions().get(i).getAnswer2()))
            {
                result=result+3;
            }
            else if(boxList.get(i).getValue().equals(Basetool.get_chosen_paper().getQuestions().get(i).getAnswer3()))
            {
                result=result+2;
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("test finish");
        alert.setHeaderText("It's finish");
        if(result>8) {
            alert.setContentText("You get " + Integer.toString(result) + ". Your healthy is all right");
        }
        else {
            alert.setContentText("You get " + Integer.toString(result) + ". Your should pay attention to your body.");
        }
        alert.showAndWait();
    }
}
