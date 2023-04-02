package Day02;

import java.io.*;
import java.util.List;
import TxtToArray.*;

public class One {
    public static void main(String[] args) throws IOException {
        List<String> zuege = ReadTxtToStringArray.readLines("Day02/Day02.txt");
        int ergebnis = 0;

        for (String zug : zuege) {

            ergebnis += returnScore(zug);
        }

        System.out.println(ergebnis);

    }

    private static int returnScore(String zug) {
        int score = 0;
        int zahl_1 = (int) zug.charAt(0) - 64;
        int zahl_2 = (int) zug.charAt(2) - 64 - 23;
        score += zahl_2;

        switch (zahl_1 - zahl_2) {
            case 0:
                score += 3;
                break;
            case -1:
                score += 6;
                break;
            case 2:
                score += 6;
                break;

            default:
                break;
        }

        return score;
    }
}