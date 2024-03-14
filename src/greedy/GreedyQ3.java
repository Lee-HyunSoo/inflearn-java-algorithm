package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 결혼식
 */
public class GreedyQ3 {

    static class Pair implements Comparable<Pair> {
        int x;
        char c;

        Pair(int x, char c) {
            this.x = x;
            this.c = c;
        }

        @Override
        public int compareTo(Pair p) {
            if (this.x == p.x) {
                return this.c - p.c;
            } else {
                return this.x - p.x;
            }
        }
    }

    static int n;
    static List<Pair> list = new ArrayList<>();

    public static void main(String[] args) {
        GreedyQ3 q = new GreedyQ3();
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            list.add(new Pair(x, 's')); // start
            list.add(new Pair(y, 'e')); // end
        }

        int answer = q.solution();
        System.out.println(answer);
    }

    public int solution() {
        int answer = 0;
        Collections.sort(list);

        int cnt = 0; // 그 시간대에 존재하면 일단 cnt -> 갱신
        for (Pair p : list) {
            if (p.c == 's') {
                cnt++;
            } else {
                cnt--;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
}
