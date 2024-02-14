package DfsBfs;

import java.util.Scanner;

/**
 * 조합의 경우수
 */
public class DBQ7 {

    static int[][] memory;

    public static void main(String[] args) {
        DBQ7 q = new DBQ7();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int r = scan.nextInt();
        memory = new int[n + 1][r + 1];
        int answer = q.solution(n, r);
        System.out.println(answer);
    }

    public int solution(int n, int r) {
        if (memory[n][r] > 0) {
            return memory[n][r];
        }
        if (n == r || r == 0) {
            return memory[n][r] = 1;
        } else {
            return memory[n][r] = solution(n - 1, r - 1) + solution(n - 1, r);
        }
    }
}
