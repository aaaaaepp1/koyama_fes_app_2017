package koyama_fes_app_2017_nb;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
背景を挿入する
フォントを変えれるようにする
文字の位置を揃える
手打ちで入力できるようにする
*/

public class Main extends Application {

    private final boolean DEBUG = false;
    private final boolean TRACE = true;
    
    
    private Label subWindowLabel;
    private Label questionLabel;
    private Label answerLabel;
    private Text borderNode1; 

    @Override
    public void start(Stage mainStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        Parent root = loader.load();
        
        koyama_fes_app_2017_nb.Controller controller = (koyama_fes_app_2017_nb.Controller) loader.getController();
        controller.setThisStage(mainStage);
        
        controller.setMainInstance(this);
        
        mainStage.setTitle("メインウィンドウ");
        mainStage.setScene(new Scene(root, 1200, 600));
        mainStage.show();
        
        subWindowLabel = new Label();
        subWindowLabel.setText("this is sub window");
        
        questionLabel = new Label();
        questionLabel.setText("--");
        
        answerLabel = new Label();

        answerLabel.setText("This Label is answerLabel");
        answerLabel.setText("--");

    }

    // サブウィンドウであるsubStageのインスタンスを生成し、レイアウトを整えてリターンするメソッド。
    public Stage createSubStage() throws IOException {
        //if(TRACE) System.out.println("createSubStage : 開発中");

        //Stage subStage = Main.createSubStage(); 
        Stage stage = new Stage();
        stage.setTitle("サブウィンドウ");
        borderNode1 = new Text("問題") ;
//        Text boText2 = new Text("解答");

        

        //ここはとりあえず記述する処理。
        AnchorPane tmpPane = new AnchorPane();
        
        
        GridPane layoutPane = new GridPane();
        layoutPane.setPadding(new Insets(10,10,10,10));
        
        /*画像出力に使用したコード
        //scene.getStylesheets().add(this.getClass().getResource("SubWindowCss.css").toExternalForm());
        //Image image = new Image(new File( "background.png" ).toURI().toString());
        //ImageView imageView = new ImageView(image);
        //System.out.println(new File(".").getAbsoluteFile().getParent());
        //tmpPane.getChildren().add(imageView);
        */
        
        borderNode1.setLayoutX(150);
        borderNode1.setLayoutY(250);
        borderNode1.setFont(Font.font("Hiragino Mincho ProN",30));
        
//        boText2.setLayoutX(150);
//        boText2.setLayoutY(520);
//        boText2.setFont(Font.font("MS明朝",30));
        
        questionLabel.setLayoutX(150);
        questionLabel.setLayoutY(300);
        questionLabel.setFont(Font.font("Hiragino Mincho ProN",50));
        
        answerLabel.setLayoutX(150);
        answerLabel.setLayoutY(530);
        answerLabel.setFont(Font.font("Hiragino Mincho ProN",50));
        
        tmpPane.getChildren().addAll(questionLabel,answerLabel,borderNode1);
        //layoutPane.add(subWindowLabel, 100, 100);
        
        Scene scene = new Scene(tmpPane, 1600,900);
        
        File backgroundImg = new File("background.png");
        tmpPane.setStyle("" +
            "-fx-background-image: url('" + backgroundImg.toURI().toString() + "'); " +
            "-fx-background-position: left top; " +
            "-fx-background-repeat: stretch;");
        
        stage.setScene(scene);
        
        
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
    
    public void changeQuestionTitleLabel(String str) {
        this.borderNode1.setText(str);
    }
    
    //font chooser 作る
    public void setFont(String str) {
        
        borderNode1.setFont(Font.font(str, 30));
        questionLabel.setFont(Font.font(str, 50));
        answerLabel.setFont(Font.font(str, 50));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
