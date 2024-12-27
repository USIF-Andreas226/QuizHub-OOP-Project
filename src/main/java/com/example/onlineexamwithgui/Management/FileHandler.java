package com.example.onlineexamwithgui.Management;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    static ArrayList<String> readFile(String fileName){
        File file = new File(fileName);
        ArrayList<String> lines = new ArrayList<>();
        try {
           file.createNewFile();


            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                lines.add(scanner.nextLine());
            }
            return lines;
        }catch (Exception e){
            System.out.println("A problem has occurred");
        }
        return new ArrayList<>();
    }


    static void writeFile(String fileName , ArrayList<String> lines){
        File file = new File(fileName);

        try {
           file.createNewFile();


            FileWriter fileWriter = new FileWriter(fileName , false);
            for (String line : lines){
                fileWriter.write(line + '\n');
            }
            fileWriter.close();
        }catch (Exception e){
            System.out.println("A problem has occurred");
        }
    }
}
