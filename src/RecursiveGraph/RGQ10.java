package RecursiveGraph;

import java.util.Scanner;

/**
 * 경로탐색 (DFS)
 */
public class RGQ10 {

    static int answer = 0;

    public static void main(String[] args) {
        RGQ10 q = new RGQ10();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            graph[x][y] = 1;
        }

        boolean[] visit = new boolean[n + 1];
        visit[1] = true;
        q.solution(graph, visit, n, 1);
        System.out.println(answer);
    }

    public void solution(int[][] graph, boolean[] visit, int n, int row) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 1; col <= n; col++) {
            if (!visit[col] && graph[row][col] == 1) {
                visit[col] = true;
                solution(graph, visit, n, col);
                visit[col] = false;
            }
        }
    }
}
