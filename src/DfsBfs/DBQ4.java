package DfsBfs;

import java.util.Scanner;

/**
 * 중복순열 구하기
 */
public class DBQ4 {

    static int[] graph;

    public static void main(String[] args) {
        DBQ4 q = new DBQ4();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        graph = new int[m];
        q.solution(0, n, m);
    }

    public void solution(int idx, int n, int m) {
        if (idx == m) {
            for (int g : graph) {
                System.out.print(g + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                graph[idx] = i;
                solution(idx + 1, n, m);
            }
        }
    }
}
