package Day10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import TxtToArray.ReadTxtToStringArray;

public class One {
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
                    System.out.println("register: " + register + " cycle: " + cycle + " temp: " + temp);
                }
            } else {
                cycle++;
                if (cycleValues.contains(cycle)) {
                    int temp = register * cycle;
                    sum += temp;
                    System.out.println("register: " + register + " cycle: " + cycle + " temp: " + temp);
                }
                
                cycle++;
                if (cycleValues.contains(cycle)) {
                    int temp = register * cycle;
                    sum += temp;
                    System.out.println("register: " + register + " cycle: " + cycle + " temp: " + temp);
                }
                register += Integer.parseInt(value);
            }
        }
        System.out.println("sum: " + sum);

    }
}
