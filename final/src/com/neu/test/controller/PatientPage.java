package com.neu.test.view;

import com.neu.test.pojo.impl.Employee;
import com.neu.test.pojo.impl.User;
import com.neu.test.service.impl.Service;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

public class PatientPage implements Initializable {
    public TextField name_f;
    public TextField age_f;
    public TableView<User> emp_t;
    public TableColumn<Employee, Boolean> select_c;
    public TableColumn<Object, Object> name_c;
    public TextField sex_F;
    public TextField phone_f;
    public TextField id_f;
    public Button add;
    public Button delete;
    public TextField contractor_f;
    public TextField search_str;
    public Button search;
    public TableColumn<Object, Object> age_c;
    public TableColumn<Object, Object> sex_c;
    public TableColumn<Object, Object> phone_c;
    public TableColumn<Object, Object> id_c;
    public TableColumn<Object, Object> contract_c;
    public TableColumn<Object, Object> contractp_c;
    public TextField contractor_p_f;
    private ObservableList<User> table_empdao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            table_empdao= FXCollections.observableArrayList(
                    Service.getInstance().get_all_usr());
//            select_c.setCellFactory(TextFieldTableCell.forTableColumn());//I don't know why it isn't working,It's different from the doc
            select_c.setCellValueFactory(new PropertyValueFactory<Employee, Boolean>("is_select"));
            name_c.setCellValueFactory(new  PropertyValueFactory<>("name"));
            age_c.setCellValueFactory(new PropertyValueFactory<>("age"));
            sex_c.setCellValueFactory(new PropertyValueFactory<>("sex"));
            phone_c.setCellValueFactory(new PropertyValueFactory<>("phone"));
            id_c.setCellValueFactory(new PropertyValueFactory<>("id"));
            contract_c.setCellValueFactory(new PropertyValueFactory<>("contractor"));
            contractp_c.setCellValueFactory(new PropertyValueFactory<>("contractphone"));
            emp_t.setItems(table_empdao);
            emp_t.getSelectionModel().selectedItemProperty().addListener(// 选中某一行
                    new ChangeListener<User>() {
                        @Override
                        public void changed(

                                ObservableValue<? extends User> observableValue,
                                User oldItem, User newItem) {
                            if(newItem!=null)
                            {
                                newItem.setIs_select(true);
                            }
                        }
                    }
            );

//            emp_t.setEditable(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void add_new(ActionEvent actionEvent) {
//        System.out.println("dddddd");
        User user=new User(id_f.getText(),name_f.getText(),sex_F.getText(),phone_f.getText(),
                contractor_f.getText(),contractor_p_f.getText(),age_f.getText());
        table_empdao.add(user);
        Service.getInstance().cover_user((List<User>) table_empdao);

    }

    public void delete_old(ActionEvent actionEvent) {
        ListIterator i=(ListIterator) table_empdao.listIterator();
        while (i.hasNext())
        {
            User tempem=(User) i.next();
            if(tempem.getIs_select())
            {
                i.remove();
            }
        }
        Service.getInstance().cover_user((List<User>)table_empdao);
    }

    public void search_(ActionEvent actionEvent) {
        try {
            if(search_str.getText()!=null&&!search_str.getText().equals("")){
                List<User> tempemdao= Service.getInstance().low_find_usr(search_str.getText());
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
