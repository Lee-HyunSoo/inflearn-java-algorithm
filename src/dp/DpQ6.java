package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 최대점수 구하기 (냅색 알고리즘)
 */
public class DpQ6 {

    static List<Pair> ques = new ArrayList<>();
    static int[] dp;

    static class Pair {
        int score, time;

        public Pair(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        DpQ6 q = new DpQ6();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        dp = new int[m + 1];

        for (int i = 0; i < n; i++) {
            int score = scan.nextInt();
            int time = scan.nextInt();
            ques.add(new Pair(score, time));
        }

        System.out.println(q.solution(n, m));
    }

    public int solution(int n, int m) {
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int s = ques.get(i).score;
            int t = ques.get(i).time;

            for (int j = m; j >= t; j--) { // 앞에서부터 돌면 같은 문제를 두번 푸는 꼴이 되버림
                dp[j] = Math.max(dp[j], dp[j - t] + s);
            }
        }
        return dp[m];
    }
}
