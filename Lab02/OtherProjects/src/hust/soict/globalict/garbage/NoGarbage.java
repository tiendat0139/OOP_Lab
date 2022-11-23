package hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * It reads a file into a byte array, then converts the byte array into a StringBuilder
 */
public class NoGarbage {
    public static void main(String[] args) throws IOException {
        String location = "C:\\Users\\ADMIN\\Documents\\OOP_lab\\Lab02\\" +
                "OtherProjects\\src\\hust\\soict\\globalict\\garbage\\";
        String filename = "test.exe";

        byte[]  inputBytes = { 0 };
        long startTime, endTime;
        inputBytes = Files.readAllBytes(Paths.get(location + filename));
        startTime = System.currentTimeMillis();
        StringBuffer outputStringBuffer = new StringBuffer();
        for (byte b : inputBytes){
            outputStringBuffer.append((char)b);
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
