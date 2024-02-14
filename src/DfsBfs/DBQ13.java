package DfsBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 섬나라 아일랜드 (DFS)
 */
public class DBQ13 {

    static int n;
    static int[][] graph;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 0, 1, 1, 1, -1, -1};
    static int[] dy = {0, -1, 1, 0, 1, -1, 1, -1};

    public static void main(String[] args) {
        DBQ13 q = new DBQ13();

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        graph = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scan.nextInt();
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && graph[i][j] == 1) {
                    visit[i][j] = true;
                    q.solution(i, j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public void solution(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (!visit[nx][ny] && graph[nx][ny] == 1) {
                    visit[nx][ny] = true;
                    solution(nx, ny);
                }
            }
        }
    }
}
