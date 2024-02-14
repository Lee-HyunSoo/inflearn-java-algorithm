package DfsBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 미로의 최단거리 통로
 */
public class DBQ11 {

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] graph = new int[8][8];
    static boolean[][] visit = new boolean[8][8];
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) {
        DBQ11 q = new DBQ11();

        Scanner scan = new Scanner(System.in);
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                graph[i][j] = scan.nextInt();
            }
        }
        q.solution(1, 1);
        System.out.println(graph[7][7] != 0 ? graph[7][7] : -1);
    }

    public void solution(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        visit[x][y] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (p.x == 7 && p.y == 7) {
                return;
            }

            for (int j = 0; j < 4; j++) {
                int nx = p.x + dx[j];
                int ny = p.y + dy[j];

                if (0 < nx && nx <= 7 && 0 < ny && ny <= 7) {
                    if (!visit[nx][ny] && graph[nx][ny] == 0) {
                        visit[nx][ny] = true;
                        graph[nx][ny] = graph[p.x][p.y] + 1;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }
}
