package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 700));
        primaryStage.show();

        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File("."));
        File mainDirectory = directoryChooser.showDialog(primaryStage);

        fileParsing file = new fileParsing();
        file.parseHamFile(mainDirectory);
        file.parseSpamFile(mainDirectory);


        Controller.Accuracy.setText(String.valueOf(Controller.f_accuracy()));
        Controller.Precision.setText(String.valueOf(Controller.f_precision()));

    }


    public static void main(String[] args) {
        launch(args);
    }
}
