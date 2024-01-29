package stackQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 올바른 괄호
 */
public class StackQueueQ1 {

    public static void main(String[] args) {
        StackQueueQ1 q = new StackQueueQ1();

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String answer = q.solution(input);
        System.out.println(answer);
    }

    public String solution(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return "NO";
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }
}
