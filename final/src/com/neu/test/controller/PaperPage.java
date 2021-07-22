package com.neu.test.controller;

import com.neu.test.basetool.impl.Basetool;
import com.neu.test.pojo.impl.Paper;
import com.neu.test.pojo.impl.Question;
import com.neu.test.service.impl.Service;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.ResourceBundle;

public class PaperPage implements Initializable {
    public TableView<Paper> emp_t;
    public TableColumn<Paper, Boolean> select_c;
    public TableColumn<Object, Object> name_c;

    public Button delete;

    public TextField search_str;
    public Button search;
    public TableColumn quest_list;
    public Button test_b;
    private ObservableList<Paper> table_empdao;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            table_empdao= FXCollections.observableArrayList(
                    Service.getInstance().get_all_paper());
//            select_c.setCellFactory(TextFieldTableCell.forTableColumn());//I don't know why it isn't working,It's different from the doc
            select_c.setCellValueFactory(new PropertyValueFactory<Paper, Boolean>("is_select"));
            name_c.setCellValueFactory(new  PropertyValueFactory<>("id"));
            quest_list.setCellValueFactory(new PropertyValueFactory<>("questions"));

            emp_t.setItems(table_empdao);
            emp_t.getSelectionModel().selectedItemProperty().addListener(// 选中某一行
                    new ChangeListener<Paper>() {
                        @Override
                        public void changed(
                                ObservableValue<? extends Paper> observableValue,
                                Paper oldItem, Paper newItem) {
                            if(newItem!=null)
                            {
                                newItem.setIs_select(!newItem.isIs_select());
                                emp_t.refresh();
                            }
                        }
                    }
            );

//            emp_t.setEditable(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void delete_old(ActionEvent actionEvent) {
        ListIterator i=(ListIterator) table_empdao.listIterator();
        while (i.hasNext())
        {
            Paper tempem=(Paper) i.next();
            if(tempem.isIs_select())
            {
                i.remove();
            }
        }
        Service.getInstance().cover_papers((List<Paper>)table_empdao);
    }

    public void search_(ActionEvent actionEvent) {
        try {
            if(search_str.getText()!=null&&!search_str.getText().equals("")){
                List<Paper> tempemdao= Service.getInstance().low_find_paper(search_str.getText());
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

    public void test(ActionEvent actionEvent) throws IOException {
        Paper testpaper=
        emp_t.getSelectionModel().getSelectedItem();
        Basetool.set_chosen_paper(testpaper);
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass()
                .getResource("/com/neu/test/fxml/test.fxml")));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("test_page");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
