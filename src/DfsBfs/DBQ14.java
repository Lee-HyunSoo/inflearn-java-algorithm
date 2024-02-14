package DfsBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 섬나라 아일랜드 (BFS)
 */
public class DBQ14 {

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int[][] graph;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 0, 1, 1, 1, -1, -1};
    static int[] dy = {0, -1, 1, 0, 1, -1, 1, -1};

    public static void main(String[] args) {
        DBQ14 q = new DBQ14();

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
                    q.solution(i, j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public void solution(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        visit[x][y] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int j = 0; j < 8; j++) {
                int nx = p.x + dx[j];
                int ny = p.y + dy[j];

                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (!visit[nx][ny] && graph[nx][ny] == 1) {
                        visit[nx][ny] = true;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }
}
