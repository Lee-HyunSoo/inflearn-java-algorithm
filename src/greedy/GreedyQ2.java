package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 회의실 배정
 */
public class GreedyQ2 {

    static class Pair implements Comparable<Pair> {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair p) {
            if (this.y == p.y) {
                return this.x - p.x;
            }
            return this.y - p.y;
        }
    }

    static int n;
    static List<Pair> list = new ArrayList<>();

    public static void main(String[] args) {
        GreedyQ2 q = new GreedyQ2();
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            list.add(new Pair(x, y));
        }

        int answer = q.solution();
        System.out.println(answer);
    }

    public int solution() {
        int answer = 0;
        Collections.sort(list);
        int y = 0;
        for (Pair p : list) {
            if (p.x >= y) {
                y = p.y;
                answer++;
            }
        }
        return answer;
    }
}
