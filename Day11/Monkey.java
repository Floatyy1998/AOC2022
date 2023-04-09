package Day11;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Monkey {
    private final int id;
    private Deque<Long> items = new ArrayDeque<>();
    private String operation;
    private String operationValue;
    private int test;
    private int trueValue;
    private int falseValue;
    private int inspections = 0;
    private String name;

    public Monkey(String id) {
        this.id = Integer.parseInt(id);
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addItem(Long item) {
        this.items.add(item);
    }

    public void addItem(String item) {
        this.items.add(Long.parseLong(item));
    }

    public String getOperation() {
        return this.operation;
    }

    public Deque<Long> getItems() {
        return this.items;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperationValue() {
        return this.operationValue;
    }

    public void setOperationValue(String operationValue) {
        this.operationValue = operationValue;
    }

    public int getTest() {
        return this.test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    public int getTrueValue() {
        return this.trueValue;
    }

    public void setTrueValue(int trueValue) {
        this.trueValue = trueValue;
    }

    public int getFalseValue() {
        return this.falseValue;
    }

    public void setFalseValue(int falseValue) {
        this.falseValue = falseValue;
    }

    public int getInspections() {
        return this.inspections;
    }

    public void printInspections() {
        System.out.println("Monkey " +this.id+ " inspected items " +this.inspections+ " times.");
    }

    public void round1(Map<Integer, Monkey> monkeyMap) {

        while (!this.items.isEmpty()) {
            long item = this.items.pop();

            if (this.operationValue.equals("old")) {
                if (operation.equals("*")) {
                //    System.out.println(item + " * " + item);
                    item *= item;
                   
                } else {
                    item += item;
                }
            } else {
                if (operation.equals("*")) {
                //    System.out.println(item + " * " + this.operationValue);
                    item *= Long.parseLong(this.operationValue);
                } else {
                 //   System.out.println(item + " * " + this.operationValue);
                    item += Long.parseLong(this.operationValue);

                }
            }

            this.inspections++;

            item /=3;
            

            if (item % this.test == 0) {
              //  System.out.println(item + " to "+ this.trueValue);
                monkeyMap.get(this.trueValue).addItem(item);
            } else {
              //  System.out.println(item + " to "+ this.falseValue);
                monkeyMap.get(this.falseValue).addItem(item);
            }

        }

    }
    public void round2(Map<Integer, Monkey> monkeyMap) {

        while (!this.items.isEmpty()) {
            long item = this.items.pop();

            if (this.operationValue.equals("old")) {
                if (operation.equals("*")) {
                //    System.out.println(item + " * " + item);
                    item *= item;
                   
                } else {
                    item += item;
                }
            } else {
                if (operation.equals("*")) {
                //    System.out.println(item + " * " + this.operationValue);
                    item *= Long.parseLong(this.operationValue);
                } else {
                 //   System.out.println(item + " * " + this.operationValue);
                    item += Long.parseLong(this.operationValue);

                }
            }

            this.inspections++;

            item %= 9699690;

            

            if (item % this.test == 0) {
              //  System.out.println(item + " to "+ this.trueValue);
                monkeyMap.get(this.trueValue).addItem(item);
            } else {
              //  System.out.println(item + " to "+ this.falseValue);
                monkeyMap.get(this.falseValue).addItem(item);
            }

        }

    }

}
