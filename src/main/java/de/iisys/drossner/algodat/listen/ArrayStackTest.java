package de.iisys.drossner.algodat.listen;

public class ArrayStackTest {

    public static void main(String[] args) {
        Stack<String> stack = new ArrayStack<>(3);
        Stack<String> stack2 = new VerketteteListe<>();

        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
    }

}
