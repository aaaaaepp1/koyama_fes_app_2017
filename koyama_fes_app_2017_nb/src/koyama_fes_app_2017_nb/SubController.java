package koyama_fes_app_2017_nb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.beans.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

/**
 * Created by ushiohiroto on 2017/08/25.
 */
public class SubController implements Initializable {


    @FXML
    private Label questionLabel;
    @FXML
    private Label answerLabel;
    private Main main;
    private Stage subStage;

    private void loadFXML() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SubWindow.fxml"));
        fxmlLoader.setRoot(this);
        
        // 自分自身をコントロールとして設定
        fxmlLoader.setController(this);
        
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

    }

    void LayoutQuestion(String output) {
        questionLabel.setText("Yes");
    }

    void setThisStage(Stage stage) {
        this.subStage = stage;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setSubInstance(Main aThis) {
        
        this.main = aThis;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
