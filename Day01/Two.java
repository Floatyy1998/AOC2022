package Day01;

import java.io.*;

import java.util.Arrays;
import java.util.List;

public class Two {
    public static void main(String[] args) throws IOException {
        List<Integer> test = ReadTxtToArray.readLines("Day01/Day1.txt");
        int ergebnis = 0;
        int zwischen = 0;
        int[] vertgleich = { 0, 0, 0 };

        for (int i = 0; i < test.size(); i++) {
            if (test.get(i) != -1) {
                zwischen = zwischen + test.get(i);

            } else {
                for (int j = 0; j < vertgleich.length; j++) {
                    if (zwischen > vertgleich[j]) {
                        vertgleich[j] = zwischen;
                        Arrays.sort(vertgleich);
                        // System.out.println(vertgleich[j]);
                        break;
                    }
                }

                zwischen = 0;
            }

        }
        for (int i : vertgleich) {
            ergebnis = ergebnis + i;
        }
        System.out.println(ergebnis);

    }
}

