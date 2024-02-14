package DfsBfs;

import java.util.Scanner;

/**
 * 수열 추측하기
 */
public class DBQ8 {

    static int n, f;
    static int[] combi, permu;
    static boolean[] visit;
    static int[][] memory;
    static boolean flag = false;

    public static void main(String[] args) {
        DBQ8 q = new DBQ8();

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        f = scan.nextInt();

        combi = new int[n];
        permu = new int[n];
        visit = new boolean[n + 1];
        memory = new int[n + 1][f + 1];

        for (int i = 0; i < n; i++) {
            combi[i] = q.combination(n - 1, i);
        }
        q.solution(0, 0);
    }

    public int combination(int n, int r) {
        if (memory[n][r] > 0) {
            return memory[n][r];
        }
        if (n == r || r == 0) {
            return memory[n][r] = 1;
        } else {
            return memory[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
        }
    }

    public void solution(int level, int sum) {
        if (flag) {
            return;
        }
        if (level == n) {
            if (sum == f) {
                for (int i : permu) {
                    System.out.print(i + " ");
                }
                flag = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    permu[level] = i;
                    solution(level + 1, sum + (permu[level] * combi[level]));
                    visit[i] = false;
                }
            }
        }
    }
}
