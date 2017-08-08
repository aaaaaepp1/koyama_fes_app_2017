package koyamaFesAppJudge;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private final boolean DEBUG = false;
    private final boolean TRACE = true;

    @Override
    public void start(Stage mainStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        mainStage.setTitle("メインウィンドウ");
        mainStage.setScene(new Scene(root, 300, 275));
        mainStage.show();

        Stage subStage = this.createSubStage();
        subStage.initOwner(mainStage);
        subStage.show();

    }

    // サブウィンドウであるsubStageのインスタンスを生成し、レイアウトを整えてリターンするメソッド。
    private Stage createSubStage() {
        if(TRACE) System.out.println("createSubStage : 開発中");


        Stage stage = new Stage();
        stage.setTitle("サブウィンドウ");


        //ここはとりあえず記述する処理。
        Label tmpLabel = new Label();
        tmpLabel.setText("this is sub window");
        BorderPane tmpPane = new BorderPane();
        tmpPane.setCenter(tmpLabel);
        //ここまでとりあえず記述する処理。


        stage.setScene(new Scene(tmpPane, 800, 600));

        return stage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
