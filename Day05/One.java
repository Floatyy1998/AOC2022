package Day05;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import TxtToArray.ReadTxtToStringArrayMinus1;

/**
 * One
 */
public class One {

    public static void main(String[] args) throws IOException {

        List<String> list = ReadTxtToStringArrayMinus1.readLines("Day05/Day05.txt");
        List<String> list2 = new ArrayList<>();
        List<String> list1 = new ArrayList<>();

        for (String string : list) {
            if (string == "-1") {
                break;
            } else {
                list2.add(string);
            }
        }

        for (int i = 0; i < list2.size(); i++) {

            String string = list2.get(i).replace("[", " ").replace("]", " ");
            list2.set(i, string);

        }

        int size = (list2.get(0).length() / 4) + 1;
        Stack<String>[] stacks = new Stack[size];

        for (int i = 0; i < size; i++) {
            stacks[i] = new Stack<>();
        }

        for (String string : list2) {
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) != ' ') {
                    int index = (i / 4);
                    stacks[index].push(string.substring(i, i + 1));

                    i += 1;

                }
            }

        }
        for (int i = 0; i < stacks.length; i++) {

            stacks[i].pop();

        }
        for (int i = 0; i < stacks.length; i++) {
            reverseStack(stacks[i]);
        }
        // System.out.println(stacks[8]);

        for (int i = 10; i < list.size(); i++) {

            list1.add(list.get(i));
        }

        for (String line : list1) {
            String[] moves = line.split(" ");
            moveCrates(stacks, Integer.valueOf(moves[1]), Integer.valueOf(moves[3]), Integer.valueOf(moves[5]));
        }

        String result = "";
        for (int i = 0; i < size; i++) {
            if (!stacks[i].isEmpty()) {
                result += stacks[i].peek();
            }
        }
        System.out.println(result);

    }

    private static void moveCrates(Stack<String>[] stacks, int quantity, int fromStackIndex,
            int toStackIndex) {
        for (int i = 0; i < quantity; i++) {
            stacks[toStackIndex - 1].push(stacks[fromStackIndex - 1].pop());
        }

    }

    private static void reverseStack(Stack<String> stack) {
        if (stack.isEmpty()) {
            return;
        }
        String top = stack.pop();
        reverseStack(stack);
        insertBottom(stack, top);
    }

    private static void insertBottom(Stack<String> stack, String value) {
        if (stack.isEmpty()) {
            stack.add(value);
        } else {
            String top = stack.pop();
            insertBottom(stack, value);
            stack.add(top);
        }
    }

}