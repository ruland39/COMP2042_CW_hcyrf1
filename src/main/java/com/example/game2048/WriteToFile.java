package com.example.game2048;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteToFile {

    public static void writeToFile(String name, String text){
        try {
            File myObj = new File(name);

            FileWriter fileWriter = new FileWriter(name);
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void updateFile(String name, String text) throws IOException {
        File myObj = new File(name);

        List<String> allUserAccount = new ArrayList<>();

        Scanner myReader = new Scanner(myObj);

        String currentUser[] = text.split(";");
        String userName = currentUser[0];

        while (myReader.hasNextLine()){
            String data = myReader.nextLine();
            String oldUser[] = data.split(";");
            String oldUserName = oldUser[0];
            if(!userName.equals(oldUserName)){
                allUserAccount.add(data);
            }

        }
        allUserAccount.add(text);
    }

    public static List<String> getAllScore(String name) throws FileNotFoundException {
        File myObj = new File(name);

        List<String> allUserAccount = new ArrayList<>();

        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()){
            String data = myReader.nextLine();
            allUserAccount.add(data);

        }

        return allUserAccount;
    }
}
