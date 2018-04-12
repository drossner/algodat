package de.iisys.drossner.algodat.listen;

public class StackTest {

    public static void main(String[] args) {
        Stack<String> stack = new VerketteteListe<>();

        stack.push("Harald");
        stack.push("Hund");
        stack.push("Test");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
