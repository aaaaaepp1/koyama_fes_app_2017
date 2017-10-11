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
    
    
    private Label subWindowLabel;

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
    }

    // サブウィンドウであるsubStageのインスタンスを生成し、レイアウトを整えてリターンするメソッド。
    public Stage createSubStage() {
        //if(TRACE) System.out.println("createSubStage : 開発中");

        //Stage subStage = Main.createSubStage(); 
        Stage stage = new Stage();
        stage.setTitle("サブウィンドウ");


        //ここはとりあえず記述する処理。
        BorderPane tmpPane = new BorderPane();
        tmpPane.setCenter(subWindowLabel);
        //ここまでとりあえず記述する処理。


        stage.setScene(new Scene(tmpPane, 800, 600));

        return stage;
    }
    
    public void changeSubwindowLabel(String str) {
        this.subWindowLabel.setText(str);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
