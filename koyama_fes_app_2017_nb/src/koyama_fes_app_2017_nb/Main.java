package koyama_fes_app_2017_nb;

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        Parent root = loader.load();

        koyama_fes_app_2017_nb.Controller controller = (koyama_fes_app_2017_nb.Controller) loader.getController();
        controller.setThisStage(mainStage);

        mainStage.setTitle("メインウィンドウ");
        mainStage.setScene(new Scene(root, 800, 800));
        mainStage.show();
    }

    // サブウィンドウであるsubStageのインスタンスを生成し、レイアウトを整えてリターンするメソッド。
    static Stage createSubStage() {
        //if(TRACE) System.out.println("createSubStage : 開発中");


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
