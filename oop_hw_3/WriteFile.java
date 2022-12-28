package oop_hw_3;

import java.io.*;

public class WriteFile {
    public void writeFile(String text) {
        try (FileWriter writer = new FileWriter("Result.txt", true)) {

            writer.write(text + "\n");

            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}