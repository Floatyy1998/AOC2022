package Day05;

import java.util.Stack;

/**
 * One
 */
public class temp {

    public static void main(String[] args) {
        Stack<Character>[] stacks = new Stack[3];
        for (int i = 0; i < 3; i++) {
            stacks[i] = new Stack<>();
        }
        
        stacks[0].push('Z');
        stacks[0].push('N');
        stacks[1].push('M');
        stacks[1].push('C');
        stacks[1].push('D');
        stacks[2].push('P');

        moveCrates(stacks, 1, 2, 1);
        moveCrates(stacks, 3, 1, 3);
        moveCrates(stacks, 2, 2, 1);
        moveCrates(stacks, 1, 1, 2);

        String result = "";
        for (int i = 0; i < 3; i++) {
            if (!stacks[i].isEmpty()) {
                result += stacks[i].peek();
            }
        }
        System.out.println(result);
    }

    private static void moveCrates(Stack<Character>[] stacks, int quantity, int fromStackIndex,
                                   int toStackIndex) {
        for (int i = 0; i < quantity; i++) {
            stacks[toStackIndex-1].push(stacks[fromStackIndex - 1].pop());
        }
       
    }

}