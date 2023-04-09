package Day09;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import TxtToArray.ReadTxtToStringArray;

public class One {
    static Pair posHead = new Pair(0, 0);
    static Pair posTail = new Pair(0, 0);
    static Set<Pair> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        // read input into string array
        List<String> input = ReadTxtToStringArray.readLines("Day09/Day09.txt");

        visited.add(new Pair(0, 0));
       

        for (String string : input) {
            String direction = string.split(" ")[0];
            int distance = Integer.parseInt(string.split(" ")[1]);

            for (int i = 0; i < distance; i++) {
                moveAStep(direction);
            }

        }

        System.out.println(visited);
        System.out.println(visited.size());

    }

    private static void moveAStep(String direction) {
        switch (direction) {
            case "U":
                posHead.moveU();
                break;
            case "D":
                posHead.moveD();
                break;
            case "L":
                posHead.moveL();
                break;
            case "R":
                posHead.moveR();
                break;
            default:
                break;
        }

        boolean moveX = posHead.getDifferenceX(posTail) > 1;
        boolean moveY = posHead.getDifferenceY(posTail) > 1;
        boolean moveXY = posHead.getDifferenceXY(posTail) > 2;

        if (moveXY) {

            if (posHead.getX() > posTail.getX()) {
                posTail.moveR();
            } else {
                posTail.moveL();
            }
            if (posHead.getY() > posTail.getY()) {
                posTail.moveU();
            } else {
                posTail.moveD();
            }
        } else if (moveX) {

            if (posHead.getX() > posTail.getX()) {
                posTail.moveR();
            } else {
                posTail.moveL();
            }
        } else if (moveY) {

            if (posHead.getY() > posTail.getY()) {
                posTail.moveU();
            } else {
                posTail.moveD();
            }
        }

        addIfNotExists(new Pair(posTail.getX(), posTail.getY()));

    }

    private static void addIfNotExists(Pair newPair) {
        boolean add = true;
        for (Pair pair : visited) {
            if (pair.getX() == newPair.getX() && pair.getY() == newPair.getY()) {
                add = false;
            }
        }
        if (add) {
            visited.add(newPair);
        }
    }

}
