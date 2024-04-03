package dp;

import java.util.Scanner;

/**
 * 최대 부분 증가수열
 */
public class DpQ3 {

    static int[] arr;
    static int[] dp;


    public static void main(String[] args) {
        DpQ3 q = new DpQ3();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        arr = new int[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.println(q.solution(n));
    }

    public int solution(int n) {
        int answer = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j] && max < dp[j]) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            answer = Math.max(dp[i], answer);
        }
        return answer;
    }
}
