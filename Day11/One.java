package Day11;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import TxtToArray.ReadTxtToStringArray;

public class One {
    public static void main(String[] args) throws IOException {
        List<String> lines = ReadTxtToStringArray.readLines("Day11/Day11.txt");

        Monkey monkey = null;
        List<Monkey> monkeys = new ArrayList<Monkey>();

        Pattern monkeyPattern = Pattern.compile("Monkey (\\d):");
        Pattern operationPattern = Pattern.compile("Operation: new = old ([*+]) ([\\d a-z]+)");
        Pattern testPattern = Pattern.compile("Test: divisible by (\\d+)");
        Pattern truePattern = Pattern.compile("If true: throw to monkey (\\d+)");
        Pattern falsePattern = Pattern.compile("If false: throw to monkey (\\d+)");

        for (String line : lines) {
            Matcher monkeyMatcher = monkeyPattern.matcher(line.trim());

            if (monkeyMatcher.find()) {
                monkey = new Monkey(monkeyMatcher.group(1));
                monkeys.add(monkey);
            }

            if (line.trim().startsWith("Name: ")) {
                monkey.setName(line.trim().substring("Name: ".length()));
            }

            if (line.trim().startsWith("Starting items: ")) {
                String[] items = line.trim().substring("Starting Items: ".length()).split(", ");
                for (String item : items) {
                    monkey.addItem(item);
                }

            }

            Matcher operationMatcher = operationPattern.matcher(line.trim());
            if (operationMatcher.find()) {
                monkey.setOperation(operationMatcher.group(1));
                monkey.setOperationValue(operationMatcher.group(2));
            }

            Matcher testMatcher = testPattern.matcher(line.trim());
            if (testMatcher.find()) {
                monkey.setTest(Integer.parseInt(testMatcher.group(1)));
            }

            Matcher trueMatcher = truePattern.matcher(line.trim());
            if (trueMatcher.find()) {
                monkey.setTrueValue(Integer.parseInt(trueMatcher.group(1)));
            }

            Matcher falseMatcher = falsePattern.matcher(line.trim());
            if (falseMatcher.find()) {
                monkey.setFalseValue(Integer.parseInt(falseMatcher.group(1)));
            }


        }

        Map<Integer, Monkey> monkeyMap = new HashMap<>();
        for (Monkey monkey1 : monkeys) {
            monkeyMap.put(monkey1.getId(), monkey1);
        }

        System.out.println("Round 0");
       for (Monkey monkey2 : monkeys) {
        System.out.println("Monkey " + monkey2.getId() + ": " + monkey2.getItems());
       }

       for (int i = 0; i < 20; i++) {
        for (Monkey monkey1 : monkeys) {
            monkey1.round1(monkeyMap);
        }
        int round = i + 1;
        System.out.println("Round "+round);
        for (Monkey monkey2 : monkeys) {
            System.out.println("Monkey " + monkey2.getId() + ": " + monkey2.getItems());
           }
       }

       

        List<Integer> inspections = new ArrayList<>();
        for (Monkey monkey1 : monkeys) {
            inspections.add(monkey1.getInspections());
        }

        inspections.sort((a, b) -> b - a);

        System.out.println(BigInteger.valueOf(inspections.get(0)).multiply(BigInteger.valueOf(inspections.get(1)))); 

    }
}
