package hust.soict.globalict.garbage;

import java.io.*;

public class NoGarbage {

    public void createNoGarbage(String filePath) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            // Efficient string concatenation using StringBuilder
            result.append(line);
        }

        reader.close();
    }

    public static void main(String[] args) throws IOException {
        NoGarbage noGarbage = new NoGarbage();
        noGarbage.createNoGarbage("largefile.txt");  // Replace with the path to a very large file
    }
}
