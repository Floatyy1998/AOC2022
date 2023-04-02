package Day03;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import TxtToArray.*;

public class Two {
    public static void main(String[] args) throws IOException {
        List<String> rucksack = ReadTxtToStringArray.readLines("Day03/Day03.txt");
        int ergebnis = 0;

        for (int i = 0; i < rucksack.size(); i += 3) {
            String one = rucksack.get(i);
            String two = rucksack.get(i+1);
            String three = rucksack.get(i+2);
            HashSet<Character> itemSet = new HashSet<Character>();

            for (int j = 0; j < one.length(); j++) {
                if (two.contains(String.valueOf(one.charAt(j))) && three.contains(String.valueOf(one.charAt(j)))) {

                    itemSet.add(one.charAt(j));

                }
            }
            //System.out.println(itemSet);
            for (char chars : itemSet) {
                if (Character.isUpperCase(chars)) {
                    ergebnis += (int) chars - 38;
                } else {
                    ergebnis += (int) chars - 96;
                }
            }
            
        }

       

        System.out.println(ergebnis);
    }

}