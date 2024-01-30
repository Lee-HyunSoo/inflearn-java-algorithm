package stackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 공주 구하기
 */
public class StackQueueQ6 {

    public static void main(String[] args) {
        StackQueueQ6 q = new StackQueueQ6();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        int answer = q.solution(n, k);
        System.out.println(answer);
    }

    public int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        int cnt = 1;
        while (q.size() != 1) {
            if (cnt == k) {
                q.poll();
                cnt = 1;
            }
            cnt++;
            q.add(q.poll());
        }
        answer = q.poll();
        return answer;
    }
}
