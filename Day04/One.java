package Day04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import TxtToArray.ReadTxtToStringArray;

public class One {
    public static void main(String[] args) throws IOException {
        List<String> sections = ReadTxtToStringArray.readLines("Day04/Day04.txt");
        int counter = 0;
        for (String sectionLine : sections) {
            String[] parts = sectionLine.split(",");
            List<Integer> section_1 = new ArrayList<Integer>();
            List<Integer> section_2 = new ArrayList<Integer>();
            List<Integer> swap = new ArrayList<Integer>();
            String[]minMax_1 = parts[0].split("-");
            String[]minMax_2 = parts[1].split("-");
            boolean contains = true;


            for (int i = Integer.parseInt(minMax_1[0]); i <= Integer.parseInt(minMax_1[1]); i++) {
                section_1.add(i);
            }

            for (int i = Integer.parseInt(minMax_2[0]); i <= Integer.parseInt(minMax_2[1]); i++) {
                section_2.add(i);
            }

            if (section_2.size()<section_1.size()) {
                swap=section_1;
                section_1=section_2;
                section_2=swap;
            }


            for (Integer zahl : section_1) {
                if(!section_2.contains(zahl)) {
                    contains = false;
                    break;
                }
                
                
            }
            if (contains) {
               System.out.println(section_1+" "+section_2);
                counter++;
            }

        }
        System.out.println("counter: " + counter);


    }
}
