package koyama_fes_app_2017_nb;

import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;

import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.io.*;
import java.util.concurrent.TimeUnit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Controller implements Initializable{
    ObservableList<String> questionNumbers = FXCollections.observableArrayList( "第1問", "第2問" ,"第3問" ,"第4問");
    Stage thisStage;
    Integer keepNumber = 0;

    private TableView<Data> table;
    @FXML
    private TableColumn<Object, Object> aNumColumn;
    @FXML
    private TableColumn nameColumn;
    @FXML
    private TableColumn qNumColumn;
    @FXML
    private TableColumn aExamColumn;
    @FXML
    private TextArea textArea;
    @FXML
    private ComboBox questionComboBox;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.Startnow();
        //table.getItems().add(new Data("anum", "name", "qnum", "aExam"));
        questionComboBox.getItems().addAll(questionNumbers);
    }


    @FXML//データ更新
    private void Update(ActionEvent event) throws IOException{
        for(Integer i = 0; i < 5;i++) {
            String[] argsStrings = "sample.csv".split(" ");
            FileRead(argsStrings);
            System.out.println(i);
        }
    }

    @FXML//サブウィンドウ生成
    private void OpenSubWindow(ActionEvent event) {
        Stage subStage = Main.createSubStage();
        subStage.initOwner(thisStage);
        subStage.show();
    }

    @FXML
    void SelectComboBox(){
        String value = (String) questionComboBox.getValue();
        System.out.println(value);
    }

    public void setThisStage(Stage stage){
        thisStage = stage;
    }

    private void Startnow(){//tableviewの初期化
        aNumColumn.setCellValueFactory(new PropertyValueFactory<>("answerNumber"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("handleName"));
        qNumColumn.setCellValueFactory(new PropertyValueFactory<>("questionNumber"));
        aExamColumn.setCellValueFactory(new PropertyValueFactory<>("answerExample"));
    }

    private void FileRead(String[] args) throws IOException {
        File file = new File(args[0]);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(",");
                if(keepNumber < Integer.valueOf(lines[0])){
                    table.getItems().add(new Data(lines[0],lines[1],lines[2],lines[3]));
                    keepNumber = Integer.valueOf(lines[0]);
                }
            }
        }
    }

    private void WaitTask() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
