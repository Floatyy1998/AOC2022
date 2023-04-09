package Day09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Two {


    public static final int gridSize = 1000;

    public static int[] grid = new int[gridSize * gridSize];

    public static int[] posRopX = new int[10];
    public static int[] posRopY = new int[10];

    public static void main(String[] args) throws Exception{

        Arrays.fill(posRopX, 500);
        Arrays.fill(posRopY, 500);


        BufferedReader br = new BufferedReader(new FileReader("Day09/Day09.txt"));

        String line;
        while ((line = br.readLine()) != null) {
        //for (String line : input.split("\n")) {
            String[] move = line.split(" ");
            move(move[0], Integer.parseInt(move[1]));
        }

        int amount = 0;
        for (int i : grid) {
            if (i > 0) {
                amount++;
            }
        }

        
        System.out.println(amount);
    }


    private static void move(String dir, int amount) {
        for (int i = 0; i < amount; i++) {
            moveAStep(dir);
        }
    }

    private static void moveAStep(String dir) {
        switch (dir) {
            case "U":
                posRopY[0] -= 1;
                break;
            case "D":
                posRopY[0] += 1;
                break;
            case "L":
                posRopX[0] -= 1;
                break;
            case "R":
                posRopX[0] += 1;
                break;
        }

        for (int i = 0; i < posRopX.length - 1; i++) {
            boolean moveX = Math.abs(posRopX[i] - posRopX[i + 1]) > 1;
            boolean moveY = Math.abs(posRopY[i] - posRopY[i + 1]) > 1;
            boolean moveXY = Math.abs(posRopX[i] - posRopX[i + 1]) + Math.abs(posRopY[i] - posRopY[i + 1]) > 2;

            if (moveXY) {
                if (posRopX[i] > posRopX[i + 1]) {
                    posRopX[i + 1]++;
                } else {
                    posRopX[i + 1]--;
                }
                if (posRopY[i] > posRopY[i + 1]) {
                    posRopY[i + 1]++;
                } else {
                    posRopY[i + 1]--;
                }
            } else if (moveX) {
                if (posRopX[i] > posRopX[i + 1]) {
                    posRopX[i + 1]++;
                } else {
                    posRopX[i + 1]--;
                }
            } else if (moveY) {
                if (posRopY[i] > posRopY[i + 1]) {
                    posRopY[i + 1]++;
                } else {
                    posRopY[i + 1]--;
                }
            }

           
        }
        grid[posRopY[9] * gridSize + posRopX[9]] += 1;

       
    }

  
}