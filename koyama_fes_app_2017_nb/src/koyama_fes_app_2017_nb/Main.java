package koyama_fes_app_2017_nb;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    private final boolean DEBUG = false;
    private final boolean TRACE = true;
    
    
    private Label subWindowLabel;
    private Label questionLabel;
    private Label answerLabel;

    @Override
    public void start(Stage mainStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        Parent root = loader.load();
        
        koyama_fes_app_2017_nb.Controller controller = (koyama_fes_app_2017_nb.Controller) loader.getController();
        controller.setThisStage(mainStage);
        
        controller.setMainInstance(this);
        
        mainStage.setTitle("メインウィンドウ");
        mainStage.setScene(new Scene(root, 800, 800));
        mainStage.show();
        
        subWindowLabel = new Label();
        subWindowLabel.setText("this is sub window");
        
        questionLabel = new Label();
        questionLabel.setText("--");
        
        answerLabel = new Label();
        answerLabel.setText("--");
    }

    // サブウィンドウであるsubStageのインスタンスを生成し、レイアウトを整えてリターンするメソッド。
    public Stage createSubStage() throws IOException {
        //if(TRACE) System.out.println("createSubStage : 開発中");

        //Stage subStage = Main.createSubStage(); 
        Stage stage = new Stage();
        stage.setTitle("サブウィンドウ");
        Text borderNode1 = new Text("問題") ;
        Text boText2 = new Text("解答");


        //ここはとりあえず記述する処理。
        AnchorPane tmpPane = new AnchorPane();
        
        
        GridPane layoutPane = new GridPane();
        layoutPane.setPadding(new Insets(10,10,10,10));
        
        Scene scene = new Scene(tmpPane, 1600,900);
        stage.setScene(scene);
        
        borderNode1.setLayoutX(150);
        borderNode1.setLayoutY(120);
        borderNode1.setFont(Font.font("MS明朝",30));
        
        boText2.setLayoutX(150);
        boText2.setLayoutY(520);
        boText2.setFont(Font.font("MS明朝",30));
        
        questionLabel.setLayoutX(150);
        questionLabel.setLayoutY(130);
        questionLabel.setFont(Font.font("MS明朝",50));
        
        answerLabel.setLayoutX(150);
        answerLabel.setLayoutY(530);
        answerLabel.setFont(Font.font("MS明朝",50));
        
        tmpPane.getChildren().addAll(questionLabel,answerLabel,borderNode1,boText2);
        //layoutPane.add(subWindowLabel, 100, 100);
        
        //ここまでとりあえず記述する処理。
        return stage;
    }
    
    public void changeSubwindowLabel(String str) {
        this.subWindowLabel.setText(str);
    }
    
    public void changeQuestionLabel(String str) {
        this.questionLabel.setText(str);
    }
    
    public void changeAnswerLabel(String str){
        this.answerLabel.setText(str);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
