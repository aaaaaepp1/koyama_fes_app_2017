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
import javafx.scene.paint.Material;
import javafx.stage.Stage;

public class Controller implements Initializable{
    private ObservableList<String> questionNumbers = FXCollections.observableArrayList( "第1問", "第2問" ,"第3問" ,"第4問");
    private Stage thisStage;
    private Integer keepNumber = 0;
    
    private Main main;

    @FXML
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
    
    //private final ObservableList<Data> TableDate = FXCollections.observableArrayList(new Data("anum", "name", "qnum", "aExam"));
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.Startnow();
        //table.setItems(TableDate);
        //table.getColumns().addAll(aNumColumn,nameColumn,qNumColumn,aExamColumn);
        //table.getItems().add(aNumColumn,nameColumn,qNumColumn,aExamColumn);
        table.getItems().add(new Data("anum", "name", "qnum", "aExam"));
        questionComboBox.getItems().addAll(questionNumbers);
    }
    
    public void setMainInstance(Main main) {
        this.main = main;
    }


    @FXML//データ更新
    private void Update(ActionEvent event) throws IOException{
        String[] argsStrings = "sample.csv".split(" ");
        System.out.println(Arrays.toString(argsStrings));
        FileRead(argsStrings);
        
        //=====================================
        //for debug 2017.10.11 okamoto naoki
        this.main.changeSubwindowLabel("aaaaaaaa");
        //=====================================
        
    }

    @FXML//サブウィンドウ生成
    private void OpenSubWindow(ActionEvent event) {
        Stage subStage = this.main.createSubStage();
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
        System.out.println(file);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(",");
                System.out.println(Arrays.toString(lines));
                if(keepNumber < Integer.valueOf(lines[0])){
                    System.out.println(lines[0]);
                    System.out.println(lines[1]);
                    System.out.println(lines[2]);
                    System.out.println(lines[3]);
                    table.getItems().add(new Data(lines[0],lines[1],lines[2],lines[3]));
                    keepNumber = Integer.valueOf(lines[0]);
                }
            }
        }catch(IOException e){
        
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
