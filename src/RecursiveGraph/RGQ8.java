package RecursiveGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 송아지 찾기 1
 */
public class RGQ8 {

    public static void main(String[] args) {
        RGQ8 q = new RGQ8();

        Scanner scan = new Scanner(System.in);
        int s = scan.nextInt();
        int e = scan.nextInt();

        int answer = q.solution(s, e);
        System.out.println(answer);
    }

    public int solution(int s, int e) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[10001];
        int[] arr = {-1, 1, 5};
        visit[s] = true;
        q.offer(s);

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int pos = q.poll();
                if (pos == e) {
                    return answer;
                }
                for (int j = 0; j < arr.length; j++) {
                    int newPos = pos + arr[j];
                    if (!visit[newPos] && 1 <= newPos && newPos <= 10000) {
                        visit[newPos] = true;
                        q.offer(newPos);
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}
