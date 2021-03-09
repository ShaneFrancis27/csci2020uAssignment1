package sample;

import javafx.stage.DirectoryChooser;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;



public class fileParsing {

    public int spamFiles = 0;
    public int hamFiles = 0;


    public HashMap<String,Integer> HamWordCount = new HashMap<String,Integer>();
    public HashMap<String,Integer> SpamWordCount = new HashMap<String,Integer>();

    public HashMap<String,Double> probSpam = new HashMap<String,Double>();
    public HashMap<String,Double> probHam = new HashMap<String,Double>();


    /**
     *
     * @param file
     * @throws IOException
     */
    public void parseHamFile(File file) throws IOException {
        System.out.println("Starting parsing the file:" + file.getAbsolutePath());

        if(file.isDirectory() && file.getName().equals("Ham")){

            //parse each file inside the directory
            File[] content = file.listFiles();
            assert content != null;



            //loops through each file in the folder
            for(File current: content){


                Scanner scanner = new Scanner(file);

                // loops inside the file for each word
                while (scanner.hasNext()) {
                    String token = scanner.next();
                    if (isValidWord(token)) {
                        countHamWord(token);

                        // loops through the rest of the files inside the folder to look for the same word
                        for(int k = 1 ; k < content.length ; k++){
                            Scanner scanner1 = new Scanner(current);
                            while (scanner1.hasNext()) {

                                //when it finds the word inside the other files, it increments the key's value
                                for (int j = 0 ; j < HamWordCount.size(); j++){
                                    if ( token.equals(HamWordCount.get(j))){
                                        HamWordCount.put(token, +1);

                                    }
                                }
                            }
                        }
                    }
                }
                hamFiles++;
            }
        }



    }
    /**
     *
     * @param file
     * @throws IOException
     */
    public void parseHam2File(File file) throws IOException {
        System.out.println("Starting parsing the file:" + file.getAbsolutePath());

        if(file.isDirectory() && file.getName().equals("Ham2")){

            //parse each file inside the directory
            File[] content = file.listFiles();
            assert content != null;



            //loops through each file in the folder
            for(File current: content){


                Scanner scanner = new Scanner(file);

                // loops inside the file for each word
                while (scanner.hasNext()) {
                    String token = scanner.next();
                    if (isValidWord(token)) {
                        countHamWord(token);

                        // loops through the rest of the files inside the folder to look for the same word
                        for(int k = 1 ; k < content.length ; k++){
                            Scanner scanner1 = new Scanner(current);
                            while (scanner1.hasNext()) {

                                //when it finds the word inside the other files, it increments the key's value
                                for (int j = 0 ; j < HamWordCount.size(); j++){
                                    if ( token.equals(HamWordCount.get(j))){
                                        HamWordCount.put(token, +1);

                                    }
                                }
                            }
                        }
                    }
                }
                hamFiles++;
            }
        }



    }

    /**
     *
     * @param file
     * @throws IOException
     */
    public void parseSpamFile(File file) throws IOException {

        System.out.println("Starting parsing the file:" + file.getAbsolutePath());

        if(file.isDirectory() && file.getName().equals("Spam")){

            //parse each file inside the directory
            File[] content = file.listFiles();
            assert content != null;

            //loops through each file in the folder
            for(File current: content){

                Scanner scanner = new Scanner(file);

                // loops inside the file for each word
                while (scanner.hasNext()) {
                    String token = scanner.next();
                    if (isValidWord(token)) {
                        countSpamWord(token);

                        // loops through the rest of the files inside the folder to look for the same word
                        for(int k = 1 ; k < content.length ; k++){
                            Scanner scanner1 = new Scanner(current);
                            while (scanner1.hasNext()) {

                                //when it finds the word inside the other files, it increments the key's value
                                for (int j = 0 ; j < SpamWordCount.size(); j++){
                                    if ( token.equals(SpamWordCount.get(j))){
                                        SpamWordCount.put(token, +1);

                                    }
                                }
                            }
                        }
                    }
                }
                spamFiles++;
            }
        }



    }




    /**
     *
     * @param word
     */
    private void countHamWord(String word){
        if(!HamWordCount.containsKey(word)){
            HamWordCount.put(word, 1);
        }

    }

    /**
     *
     * @param word
     */
    private void countSpamWord(String word){
        if(!SpamWordCount.containsKey(word)){
            SpamWordCount.put(word, 1);
        }

    }

    /**
     *
     * @param word
     * @return
     */
    private boolean isValidWord(String word){
        String allLetters = "^[a-zA-Z]+$";
        // returns true if the word is composed by only letters otherwise returns false;
        return word.matches(allLetters);

    }


}
