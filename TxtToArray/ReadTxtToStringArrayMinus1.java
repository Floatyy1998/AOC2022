package TxtToArray;


import java.io.*;
import java.util.*;

public class ReadTxtToStringArrayMinus1 {

    private ReadTxtToStringArrayMinus1() {

    }

    public static List < String > readLines(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String line;
        List < String > list = new ArrayList < > ();
     

        while ((line = in .readLine()) != null) {
            if (!line.isEmpty() && !line.equals("")) {
                list.add(line);
            }
            else{list.add("-1");}
        } in .close();

      
        return list;
    }
}

