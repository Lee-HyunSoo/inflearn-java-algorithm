package dp;

import java.util.*;

/**
 * 동전 교환 (냅색 알고리즘)
 */
public class DpQ5 {

    static int[] coin;
    static int[] dp;

    public static void main(String[] args) {
        DpQ5 q = new DpQ5();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = scan.nextInt();
        }
        int m = scan.nextInt();
        dp = new int[m + 1];

        System.out.println(q.solution(n, m));
    }

    public int solution(int n, int m) {
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 자기 자신은 1로 하기 위해 (예제에선 1, 2, 5)

        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= m; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
            }
        }

        return dp[m];
    }
}
