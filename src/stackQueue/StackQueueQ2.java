package stackQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 괄호문자 제거
 */
public class StackQueueQ2 {

    public static void main(String[] args) {
        StackQueueQ2 q = new StackQueueQ2();

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String answer = q.solution2(input);
        System.out.println(answer);
    }

    public String solution(String input) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
            } else if (stack.isEmpty() && Character.isAlphabetic(c)) {
                answer += c;
            }
        }
        return answer;
    }

    public String solution2(String input) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c == ')') {
                while (stack.pop() != '(');
            } else {
                stack.push(c);
            }
        }

        for (char c : stack) {
            answer += c;
        }
        return answer;
    }
}
