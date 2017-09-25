package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.beans.EventHandler;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ushiohiroto on 2017/08/25.
 */
public class SubController implements Initializable {


    @FXML
    private Label questionLabel;
    @FXML
    private Label answerLabel;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    void LayoutQuestion(String output) {
        questionLabel.setText("Yes");
    }
}
