/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koyama_fes_app_2017_nb;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author takahara
 */
public class SubWindowController extends AnchorPane implements Initializable {
    
    /** ラベルに表示するテキスト */
    private String labelText;
    
    /** ラベル */
    @FXML
    private Label label;
    
    /**
     * コンストラクタ
     * @param labelText 
     */
    public SubWindowController() {
        loadFXML();
    }
    
    /**
     * FXMLのロード
     */
    private void loadFXML() {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/koyama_fes_app_2017/SubWindow.fxml"));
        fxmlLoader.getRoot();
        // 自分自身をコントロールとして設定
        //fxmlLoader.getController();
        
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }  
    
}