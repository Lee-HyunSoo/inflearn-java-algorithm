package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 씨름선수
 */
public class GreedyQ1 {

    static class Pair implements Comparable<Pair> {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair p) {
            return p.x - this.x;
        }
    }

    static List<Pair> lst = new ArrayList<>();

    public static void main(String[] args) {
        GreedyQ1 q = new GreedyQ1();
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            lst.add(new Pair(x, y));
        }

        int answer = q.solution();
        System.out.println(answer);
    }

    public int solution() {
        int answer = 0;
        Collections.sort(lst);
        int max = Integer.MIN_VALUE;
        for (Pair p : lst) {
            if (p.y > max) {
                max = p.y;
                answer++;
            }
        }

        return answer;
    }
}
