package ds;

import java.util.Stack;

public class StackDS {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack);
        reverseStack(stack);
        System.out.println(stack);
        sortStack(stack);
        System.out.println(stack);
    }

    private static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        int e = stack.pop();
        sortStack(stack);
        sortStackUtil(stack, e);
    }

    private static void sortStackUtil(Stack<Integer> stack, int e) {
        if (stack.isEmpty() || e < stack.peek()) {
            stack.push(e);
        } else {
          int t = stack.pop();
          sortStackUtil(stack, e);
          stack.push(t);
        }
    }

    private static void reverseStack(java.util.Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        int e = stack.pop();
        reverseStack(stack);
        reverseStackUtil(stack, e);
    }

    private static void reverseStackUtil(Stack<Integer> stack, int e) {

        if (stack.isEmpty()) {
            stack.push(e);
        } else {
          int t = stack.pop();
          reverseStackUtil(stack, e);
          stack.push(t);
        }
    }
}
