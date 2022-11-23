package hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * It reads a file into a byte array, then converts the byte array into a string
 */
public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\ADMIN\\Documents\\OOP_lab\\Lab02" +
                "\\OtherProjects\\src\\hust\\soict\\globalict\\garbage" +
                "\\test.exe";

        byte[]  inputBytes = { 0 };
        long startTime, endTime;
        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b : inputBytes){
            outputString += (char)b;
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        //The program hangs or even stop working when compile
    }
}
