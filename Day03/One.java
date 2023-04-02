package Day03;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import TxtToArray.*;

public class One {
    public static void main(String[] args) throws IOException {
        List<String> rucksack = ReadTxtToStringArray.readLines("Day03/Day03.txt");
        HashSet<Character> itemSet = new HashSet<Character>();
        int ergebnis = 0;

        for (String items : rucksack) {
            int mid = items.length() / 2; // get the middle of the String
            String[] parts = { items.substring(0, mid), items.substring(mid) };
           
            itemSet.clear();
            for (int i = 0; i < parts[0].length(); i++) {
               // System.out.println(String.valueOf(parts[0].charAt(i)));
                if (parts[1].contains(String.valueOf(parts[0].charAt(i)))) {
                    itemSet.add(parts[0].charAt(i));

                }

            }
            for (char chars : itemSet) {
                if (Character.isUpperCase(chars)) {
                    ergebnis+=(int)chars-38;
                }
                else{
                    ergebnis+=(int)chars-96;
                }
            }
          

        }
       
        System.out.println(ergebnis);
    }

}