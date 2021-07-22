package com.neu.test.controller;

import com.neu.test.pojo.impl.Employee;
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
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

public class EmpPage implements Initializable {
    public TableView<Employee> emp_t;
    public TableColumn<Employee, Boolean> select_c;
    public TableColumn<Object, Object> name_c;
    public TableColumn<Object, Object> tanlent_c;
    public TableColumn<Object, Object> level_c;
    public TableColumn<Object, Object> phone_c;
    public TableColumn<Object, Object> id_c;
    public Button add;
    public Button delete;
    public TextField name_f;
    public TextField talent_f;
    public TextField level_f;
    public TextField phone_f;
    public TextField id_f;
    public TableColumn<Object, Object> type_c;
    public TextField type_f;
    public TextField search_str;
    public Button search;
    private ObservableList<Employee> table_empdao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            table_empdao= FXCollections.observableArrayList(
                    Service.getInstance().get_all_emp());
//            select_c.setCellFactory(TextFieldTableCell.forTableColumn());//I don't know why it isn't working,It's different from the doc
            select_c.setCellValueFactory(new PropertyValueFactory<Employee, Boolean>("is_select"));
            name_c.setCellValueFactory(new  PropertyValueFactory<>("name"));
            tanlent_c.setCellValueFactory(new PropertyValueFactory<>("talent"));
            level_c.setCellValueFactory(new PropertyValueFactory<>("level"));
            phone_c.setCellValueFactory(new PropertyValueFactory<>("phone"));
            id_c.setCellValueFactory(new PropertyValueFactory<>("id"));
            type_c.setCellValueFactory(new PropertyValueFactory<>("type"));
            emp_t.setItems(table_empdao);
            emp_t.getSelectionModel().selectedItemProperty().addListener(// 选中某一行
                    new ChangeListener<Employee>() {
                        @Override
                        public void changed(
                                ObservableValue<? extends Employee> observableValue,
                                Employee oldItem, Employee newItem) {
                            if(newItem!=null)
                            {
                                newItem.setIs_select(!newItem.getIs_select());
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
        Employee new_emp=new Employee(name_f.getText(),"123456",type_f.getText(),id_f.getText(),level_f.getText()
        ,talent_f.getText(),phone_f.getText());
        table_empdao.add(new_emp);
        Service.getInstance().cover_empdao((List<Employee>) table_empdao);

    }

    public void delete_old(ActionEvent actionEvent) {
        ListIterator i=(ListIterator) table_empdao.listIterator();
        while (i.hasNext())
        {
            Employee tempem=(Employee) i.next();
            if(tempem.getIs_select())
            {
                i.remove();
            }
        }
        Service.getInstance().cover_empdao((List<Employee>)table_empdao);
    }

    public void search_(ActionEvent actionEvent) {
        try {
            if(search_str.getText()!=null&&!search_str.getText().equals("")){
                List<Employee> tempemdao= Service.getInstance().low_find(search_str.getText());
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
}
