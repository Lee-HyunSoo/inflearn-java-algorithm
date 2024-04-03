package dp;

import java.util.Scanner;

/**
 * 계단오르기
 */
public class DpQ1 {

    static int[] dp;

    public static void main(String[] args) {
        DpQ1 q = new DpQ1();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        dp = new int[n + 1];
        System.out.println(q.solution(n));
    }

    public int solution(int n) {
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
