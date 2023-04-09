package Day10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import TxtToArray.ReadTxtToStringArray;

public class Two {
    public static void main(String[] args) throws IOException {
        List<String> input = ReadTxtToStringArray.readLines("Day10/Day10.txt");
        int register = 1;
        int cycle = 0;
        int sum = 0;
        List<Integer> cycleValues = new ArrayList<Integer>(
                Arrays.asList(20, 60, 100, 140, 180, 220));
        for (String string : input) {
            String command;
            String value;
            if (string.startsWith("noop")) {
                command = "noop";
                value = "0";
            } else {
                command = string.split(" ")[0];
                value = string.split(" ")[1];
            }

            if (command.equals("noop")) {
                cycle++;
                if (cycleValues.contains(cycle)) {
                    int temp = register * cycle;
                    sum += temp;
                   
                }
                drawCycle(cycle, register);
            } else {
                cycle++;
                if (cycleValues.contains(cycle)) {
                    int temp = register * cycle;
                    sum += temp;
                    
                }
                drawCycle(cycle, register);
                cycle++;
                if (cycleValues.contains(cycle)) {
                    int temp = register * cycle;
                    sum += temp;
                   
                }
                drawCycle(cycle, register);
                register += Integer.parseInt(value);
            }
        }
        System.out.println("sum: " + sum);

    }
    private static void drawCycle(int cycle, long register) {
        int currentPos = (cycle % 40);

        if (currentPos < register || currentPos > register + 2) {
            System.out.print(".");
        } else {
            System.out.print("#");
        }
        if (currentPos == 0) {
            System.out.println();
        }
    }
}
