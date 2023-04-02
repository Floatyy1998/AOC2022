package Day01;

import java.io.*;
import java.util.List;

public class One {
    public static void main(String[] args) throws IOException {
        List<Integer> test = ReadTxtToArray.readLines("Day01/Day1.txt");
        int ergebnis = 0;
        int zwischen = 0;

       for(int i = 0; i< test.size(); i++){
        if (test.get(i)!=-1) {
            zwischen=zwischen+test.get(i);
            
        }
        else{
            if (zwischen> ergebnis) {
                ergebnis=zwischen;
            }
           
            zwischen=0;
        }
       
            
        }
        System.out.println(ergebnis);
       

    }
}
