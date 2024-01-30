package stackQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 후위식 연산
 */
public class StackQueueQ4 {

    public static void main(String[] args) {
        StackQueueQ4 q = new StackQueueQ4();

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        int answer = q.solution(input);
        System.out.println(answer);
    }

    public int solution(String input) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else {
                int rt = stack.pop();
                int lt = stack.pop();

                if (c == '+') {
                    stack.push(lt + rt);
                } else if (c == '-') {
                    stack.push(lt - rt);
                } else if (c == '*') {
                    stack.push(lt * rt);
                } else if (c == '/') {
                    stack.push(lt / rt);
                }
            }
        }

        answer = stack.pop();
        return answer;
    }
}
