package Day08;

import java.io.IOException;
import java.util.List;

import TxtToArray.ReadTxtToStringArray;

public class One {
    public static void main(String[] args) throws IOException {
        List<String> list = ReadTxtToStringArray.readLines("Day08/Day08.txt");
        long counter = (list.get(0).length() * 2) + ((list.size() * 2) - 4);

        Integer[][] trees = new Integer[list.size()][list.get(0).length()];

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                trees[i][j] = Integer.parseInt(String.valueOf(list.get(i).charAt(j)));
            }
        }

        // output of trees
        for (int i = 1; i < trees.length - 1; i++) {
            for (int j = 1; j < trees[i].length - 1; j++) {
                boolean isVisibile = false;
                if (checkLeft(trees, i, j)) {
                    isVisibile = true;

                }

                if (checkRight(trees, i, j)) {
                    isVisibile = true;

                }

                if (checkTop(trees, i, j)) {
                    isVisibile = true;

                }

                if (checkBottom(trees, i, j)) {
                    isVisibile = true;

                }

                if (isVisibile) {
                    counter++;
                }

            }

        }
        System.out.println(counter);

    }

    private static boolean checkBottom(Integer[][] trees, int i, int j) {
        int zahl = trees[i][j];
        for (int j2 = j + 1; j2 < trees[i].length; j2++) {
            if (trees[i][j2] >= zahl) {
                return false;
            }

        }

        return true;
    }

    private static boolean checkTop(Integer[][] trees, int i, int j) {
        int zahl = trees[i][j];
        for (int j2 = 0; j2 <= j - 1; j2++) {
            if (trees[i][j2] >= zahl) {
                return false;
            }

        }

        return true;
    }

    private static boolean checkRight(Integer[][] trees, int i, int j) {
        int zahl = trees[i][j];
        for (int i2 = i + 1; i2 < trees[j].length; i2++) {
            if (trees[i2][j] >= zahl) {
                return false;
            }

        }

        return true;
    }

    private static boolean checkLeft(Integer[][] trees, int i, int j) {

        int zahl = trees[i][j];
        for (int i2 = 0; i2 <= i - 1; i2++) {
            if (trees[i2][j] >= zahl) {
                return false;
            }

        }
        return true;
    }

}
