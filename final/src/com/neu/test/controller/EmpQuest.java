package com.neu.test.controller;

import com.neu.test.dao.impl.Questiondao;
import com.neu.test.pojo.impl.Employee;
import com.neu.test.pojo.impl.Paper;
import com.neu.test.pojo.impl.Question;
import com.neu.test.service.impl.Service;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

public class EmpQuest implements Initializable {

    public TableView<Question> emp_t;
    public TableColumn<Question, Boolean> select_c;
    public TableColumn<Object, Object> name_c;
    public TableColumn<Object, Object> c_1;
    public TableColumn<Object, Object> c_2;
    public TableColumn<Object, Object> c_3;
    public Button add;
    public Button delete;
    public TextField name_f;
    public TextField f_1;
    public TextField f_2;
    public TextField f_3;
    public TextField search_str;
    public Button search;
    public Button to_paper_b;
    private ObservableList<Question> table_empdao;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            table_empdao= FXCollections.observableArrayList(
                    Service.getInstance().get_all_qust());
//            select_c.setCellFactory(TextFieldTableCell.forTableColumn());//I don't know why it isn't working,It's different from the doc
            select_c.setCellValueFactory(new PropertyValueFactory<Question, Boolean>("is_select"));
            name_c.setCellValueFactory(new  PropertyValueFactory<>("name"));
            c_1.setCellValueFactory(new PropertyValueFactory<>("answer1"));
            c_2.setCellValueFactory(new PropertyValueFactory<>("answer2"));
            c_3.setCellValueFactory(new PropertyValueFactory<>("answer3"));
            emp_t.setItems(table_empdao);
            emp_t.getSelectionModel().selectedItemProperty().addListener(// 选中某一行
                    new ChangeListener<Question>() {
                        @Override
                        public void changed(
                                ObservableValue<? extends Question> observableValue,
                                Question oldItem, Question newItem) {
                            if(newItem!=null)
                            {
                                newItem.setIs_select(!newItem.isIs_select());
                                emp_t.refresh();
                            }
                        }
                    }
            );

//            emp_t.setEditable(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void add_new(ActionEvent actionEvent) {
        Question new_q=new Question(name_f.getText(),f_1.getText(),f_2.getText(),f_3.getText());
        table_empdao.add(new_q);
        Service.getInstance().cover_questions((List<Question>) table_empdao);
    }

    public void delete_old(ActionEvent actionEvent) {
        ListIterator i=(ListIterator) table_empdao.listIterator();
        while (i.hasNext())
        {
            Question tempem=(Question) i.next();
            if(tempem.isIs_select())
            {
                i.remove();
            }
        }
        Service.getInstance().cover_questions((List<Question>)table_empdao);
    }

    public void search_(ActionEvent actionEvent) {
        try {
            if(search_str.getText()!=null&&!search_str.getText().equals("")){
                List<Question> tempemdao= Service.getInstance().low_find_qust(search_str.getText());
                emp_t.setItems(FXCollections.observableArrayList(
                        tempemdao));
            }
            else {
                emp_t.setItems(table_empdao);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        emp_t.refresh();
    }

    public void to_paper(ActionEvent actionEvent) {
        ListIterator i=(ListIterator) table_empdao.listIterator();
        List<Question> result=new ArrayList<>();
        while (i.hasNext())
        {
            Question tempem=(Question) i.next();
            if(tempem.isIs_select())
            {
                result.add(tempem);
            }
        }
        Paper w_paper=new Paper("Paper"+Integer.valueOf((int)Math.random()*10000).toString(),result);
        Service.getInstance().add_paper(w_paper);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Add id finish");
//            alert.setHeaderText();
        alert.setContentText("Add id finish");
        alert.showAndWait();
    }
}
