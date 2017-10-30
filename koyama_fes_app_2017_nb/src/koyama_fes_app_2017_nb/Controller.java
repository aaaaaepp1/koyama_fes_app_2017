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
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Material;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Controller implements Initializable{
    private ObservableList<String> questionNumbers = FXCollections.observableArrayList("--", "第1問", "第2問" ,"第3問" ,"第4問");
    private Stage thisStage;
    private Integer keepNumber = 0;
    
    private Main main;
    private NetworkControlManager networkControlManager;
    private AnswerManager answerManager;
    private ArrayList<Answer> answerDatekeepList;

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
    private TextField numberField;
    @FXML
    private TextField answerField;
    @FXML
    private ComboBox questionComboBox;
    @FXML
    private ComboBox fontComboBox;
    
    //private final ObservableList<Data> TableDate = FXCollections.observableArrayList(new Data("anum", "name", "qnum", "aExam"));
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.Startnow();
        try {
            this.networkControlManager = new NetworkControlManager("http://ksu-cac.sakura.ne.jp/kouyama_ogiri_2017/output.csv");
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        //table.setItems(TableDate);
        //table.getColumns().addAll(aNumColumn,nameColumn,qNumColumn,aExamColumn);
        //table.getItems().add(aNumColumn,nameColumn,qNumColumn,aExamColumn);
        table.getItems().add(new Data("anum", "name", "qnum", "aExam"));
        
        
        this.fontComboBox.getItems().addAll(Font.getFontNames());
        
        questionComboBox.getItems().addAll(questionNumbers);
    }
    
    public void setMainInstance(Main main) {
        this.main = main;
    }


    @FXML//データ更新
    private void Update(ActionEvent event) throws IOException{
        
        this.answerManager = networkControlManager.getAnswer();
        ArrayList<Answer> answerDatas;
        answerDatas = answerManager.getAnswerData();
        DataUser(answerDatas);
        this.answerDatekeepList = answerDatas;
        
    }

    @FXML//サブウィンドウ生成
    private void OpenSubWindow(ActionEvent event) throws IOException {
        Stage subStage = this.main.createSubStage();
        //subStage.initOwner(thisStage);
        subStage.show();
    }

    @FXML
    void SelectComboBox(){
        String value = (String) questionComboBox.getValue();
        if("第1問".equals(value)){
            this.main.changeQuestionLabel("ついに実現！" + System.getProperty("line.separator") + "一度はやってみたかった", "贅沢とは？");
        }else if("第2問".equals(value)){
            this.main.changeQuestionLabel("2100年オリンピック", "まさかの新種目は？");
        }else if("第3問".equals(value)){
            this.main.changeQuestionLabel("あまり嬉しくない" + System.getProperty("line.separator") + "1年分のプレゼント", "その中身は？");
        }else if("第4問".equals(value)){
            this.main.changeQuestionLabel("ひょっとして自分に" + System.getProperty("line.separator") + "超能力があるかも", "その能力とは？");
        }else {
            this.main.changeQuestionLabel("--", "--");
        }
        
        this.main.changeQuestionTitleLabel(value);
        this.main.changeAnswerLabel("--");
        
        this.main.changePosQuestionMode();
    }
    
    @FXML
    void SelectAnswer(ActionEvent event){
        Integer selectInteger = Integer.valueOf(this.numberField.getText());
        
        if(answerDatekeepList.size() > selectInteger) {
            for(Answer oneAnswerData:answerDatekeepList) {
                if(selectInteger.equals(oneAnswerData.getSn())){
                    main.changeAnswerLabel(oneAnswerData.getAns());        
                }
            }
            this.main.changePosAnswerMode();
        }
        
    }
    
    @FXML
    private void addAnswer(ActionEvent e) {
        main.changeAnswerLabel(this.answerField.getText());
        this.main.changePosAnswerMode();
    }
    
    @FXML
    void selectFont() {
        String fontName = (String)this.fontComboBox.getValue();
        this.main.setFont(fontName);
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

    private void DataUser(ArrayList<Answer> answerDateList) throws IOException {
            for (Answer oneAnswerData:answerDateList) {
                if(keepNumber <= oneAnswerData.getSn()){
                    table.getItems().add(new Data(oneAnswerData.getSn().toString(),oneAnswerData.getHn(),oneAnswerData.getQn().toString(),oneAnswerData.getAns()));
                    keepNumber = Integer.valueOf(oneAnswerData.getSn());
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
