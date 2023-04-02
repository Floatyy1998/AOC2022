package Day02;

import java.io.*;
import java.util.List;
import TxtToArray.*;

public class Two {
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
        // 9int zahl_2 = (int) zug.charAt(2) - 64 - 23;

        switch (zug.charAt(2)) {
            case 'X':
                int z2 = zahl_1 - 1;
                if (z2 < 1) {
                    z2 += 3;
                }
                score += z2;

                break;
            case 'Y':
                score += zahl_1 + 3;

                break;
            case 'Z':
                score += 6;
                int z = zahl_1 + 1;
                if (z > 3) {
                    z -= 3;
                }
                score += z;

                break;

            default:
                break;
        }
        System.out.println(score);
        return score;
    }
}