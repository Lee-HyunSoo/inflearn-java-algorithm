package RecursiveGraph;

import java.util.Scanner;

/**
 * 피보나치 재귀
 */
public class RGQ4 {

    static int[] fibo;

    public static void main(String[] args) {
        RGQ4 q = new RGQ4();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        fibo = new int[n + 1];
        q.solution(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }

    public int solution(int n) {
        // 메모이제이션
        if (fibo[n] > 0) {
            return fibo[n];
        }

        if (n == 1) {
            return fibo[n] = 1;
        } else if (n == 2) {
            return fibo[n] = 1;
        } else {
            return fibo[n] = solution(n - 2) + solution(n - 1);
        }
    }
}
