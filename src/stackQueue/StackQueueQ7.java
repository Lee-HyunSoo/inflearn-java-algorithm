package stackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 교육과정 설계
 */
public class StackQueueQ7 {

    public static void main(String[] args) {
        StackQueueQ7 q = new StackQueueQ7();

        Scanner scan = new Scanner(System.in);
        String input1 = scan.nextLine();
        String input2 = scan.nextLine();

        String answer = q.solution(input1, input2);
        System.out.println(answer);
    }

    public String solution(String input1, String input2) {
        Queue<Character> q = new LinkedList<>();
        for (char c : input1.toCharArray()) {
            q.add(c);
        }

        for (char c : input2.toCharArray()) {
            if (!q.isEmpty() && c == q.peek()) {
                q.poll();
            }
        }
        return q.isEmpty() ? "YES" : "NO";
    }
}
