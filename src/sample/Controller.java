package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    private static fileParsing x;
    public TableColumn File;
    public TableColumn Class;
    public static TableColumn Probability;
    public static TextField Accuracy;
    public static TextField Precision;
    public ScrollPane scrollview;
    public TableView tableView;



    public static int numTrueNegatives = 0;
    public static int numTruePositives = 0;
    public static int numFalsePositives = 0;
    public static int spam_files = 0;
    public static int ham_files = 0;
    public static double accuracy = 0;
    public static double precision = 0;

    @FXML
    public void initialize() {

        File.setCellValueFactory(new PropertyValueFactory<>("filename"));
        Class.setCellValueFactory(new PropertyValueFactory<>("actualClass"));
        Probability.setCellValueFactory(new PropertyValueFactory<>("spamProbabilityRounded"));


    }

    //accuracy calc function
    public static double f_accuracy(){
        accuracy = (double)(numTruePositives + numTrueNegatives)/(double)(spam_files + ham_files);
        return accuracy;
    }

    //precision calc function
    public static double f_precision(){
        precision = (double)(numTruePositives /(double)(numTruePositives + numFalsePositives));
        return precision;
    }


    public static void probabilitySpam(){
        for (String key : x.SpamWordCount.keySet()){
            double prob = x.SpamWordCount.get(key) / x.spamFiles;
            x.probSpam.put(key, prob);
        }
    }

    public static void probabilityHam(){
        for (String key : x.HamWordCount.keySet()){
            double prob = x.HamWordCount.get(key) / x.hamFiles;
            x.probHam.put(key, prob);
        }
    }


}
