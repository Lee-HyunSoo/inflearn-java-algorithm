package stackQueue;

import java.util.*;

/**
 * 응급실
 */
public class StackQueueQ8 {

    public static void main(String[] args) {
        StackQueueQ8 q = new StackQueueQ8();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        int answer = q.solution(n, m, arr);
        System.out.println(answer);
    }

    static class Pair {
        int id;
        int priority;

        public Pair(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            q.add(new Pair(i, arr[i]));
        }

        while (!q.isEmpty()) {
            Pair p = q.poll();

            boolean flag = false;
            for (Pair pair : q) {
                if (pair.priority > p.priority) {
                    q.add(p);
                    flag = true;
                    break;
                }
            }

            if (!flag && p.id == m) {
                return answer;
            } else {
                answer++;
            }
        }
        return answer;
    }
}
