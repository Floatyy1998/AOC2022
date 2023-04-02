package TxtToArray;

import java.io.*;
import java.util.*;

public class ReadTxtToStringArray {
    private ReadTxtToStringArray() {

    }

    public static List<String> readLines(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String line;
        List<String> list = new ArrayList<>();

        while ((line = in.readLine()) != null) {

            list.add(line);

        }
        in.close();

        return list;
    }
}