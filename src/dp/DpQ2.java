package dp;

import java.util.Scanner;

/**
 * 돌다리 건너기
 */
public class DpQ2 {

    static int[] dp;

    public static void main(String[] args) {
        DpQ2 q = new DpQ2();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        dp = new int[n + 2];
        System.out.println(q.solution(n));
    }

    public int solution(int n) {
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n + 1];
    }
}
