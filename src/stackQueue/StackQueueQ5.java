package stackQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 쇠막대기
 */
public class StackQueueQ5 {

    public static void main(String[] args) {
        StackQueueQ5 q = new StackQueueQ5();

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        int answer = q.solution(input);
        System.out.println(answer);
    }

    public int solution(String input) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(input.charAt(i));
            } else {
                stack.pop();
                if (input.charAt(i - 1) == '(') {
                    answer += stack.size(); // 자른 만큼 더해준다.
                } else {
                    answer++; // 막대의 자투리 부분
                }
            }
        }
        return answer;
    }
}
