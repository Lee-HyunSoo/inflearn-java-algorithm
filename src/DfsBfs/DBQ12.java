package DfsBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 토마토
 */
public class DBQ12 {

    static class Pair {

        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    static int m, n;
    static int[][] graph;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) {
        DBQ12 q = new DBQ12();

        Scanner scan = new Scanner(System.in);
        m = scan.nextInt();
        n = scan.nextInt();

        graph = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = scan.nextInt();
            }
        }
        int answer = q.solution();
        System.out.println(answer);
    }

    public int solution() {
        int answer = 0;

        Queue<Pair> q = new LinkedList<>();
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && graph[i][j] == 1) {
                    q.add(new Pair(i, j));
                    visit[i][j] = true;
                    flag = true;
                }
            }
        }

        if (!flag) {
            return 0;
        }

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (!visit[nx][ny] && graph[nx][ny] == 0) {
                        visit[nx][ny] = true;
                        graph[nx][ny] = graph[p.x][p.y] + 1;
                        q.add(new Pair(nx, ny));
                        answer = Math.max(answer, graph[nx][ny]);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    return -1;
                }
            }
        }
        return answer - 1;
    }
}
