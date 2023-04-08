package Day08;

import java.io.IOException;
import java.util.List;

import TxtToArray.ReadTxtToStringArray;

public class Two {
    public static void main(String[] args) throws IOException {
        List<String> list = ReadTxtToStringArray.readLines("Day08/Day08.txt");

        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;
        int max = 0;

        Integer[][] trees = new Integer[list.size()][list.get(0).length()];

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                trees[i][j] = Integer.parseInt(String.valueOf(list.get(i).charAt(j)));
            }
        }

        // output of trees
        for (int i = 1; i < trees.length - 1; i++) {
            for (int j = 1; j < trees[i].length - 1; j++) {

                left = checkLeft(trees, i, j);

                right = checkRight(trees, i, j);

                top = checkTop(trees, i, j);

                bottom = checkBottom(trees, i, j);
               
                if (left * bottom * right * top > max) {

                    max = left * bottom * right * top;
                }

            }

        }
        System.out.println(max);

    }

    private static int checkBottom(Integer[][] trees, int i, int j) {
        int zahl = trees[i][j];
        int counter = 1;
        
        for (int zeile = j+1; zeile < trees[i].length-1; zeile++) {
            if(trees[i][zeile] >= zahl) {
                return counter;
            }
            else {
                counter++;
            }
            
        }

        return counter;
    }

    private static int checkTop(Integer[][] trees, int i, int j) {
        int zahl = trees[i][j];
        int counter = 1;
        for (int zeile = j-1; zeile >0; zeile--) {
            if(trees[i][zeile] >= zahl) {
                return counter;
            }
            else {
                counter++;
            }
            
        }


        return counter;
    }

    private static int checkRight(Integer[][] trees, int i, int j) {
        int zahl = trees[i][j];
        int counter = 1;

        for (int spalte = i+1; spalte < trees.length-1; spalte++) {
            if(trees[spalte][j] >= zahl) {
                return counter;
            }
            else {
                counter++;
            }
            
        }

        return counter;
    }

    private static int checkLeft(Integer[][] trees, int i, int j) {
        int zahl = trees[i][j];
        int counter = 1;
        for (int spalte = i-1; spalte >0; spalte--) {
            if(trees[spalte][j] >= zahl) {
                return counter;
            }
            else {
                counter++;
            }
            
        }


        return counter;
    }

}
