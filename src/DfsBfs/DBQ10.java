package DfsBfs;

import java.util.Scanner;

/**
 * 미로 탐색
 */
public class DBQ10 {

    static int[][] graph = new int[8][8];
    static boolean[][] visit = new boolean[8][8];
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int answer = 0;

    public static void main(String[] args) {
        DBQ10 q = new DBQ10();

        Scanner scan = new Scanner(System.in);
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                graph[i][j] = scan.nextInt();
            }
        }
        visit[1][1] = true;
        q.solution(1, 1);
        System.out.println(answer);
    }

    public void solution(int x, int y) {
        if (x == 7 && y == 7) {
            answer++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 < nx && nx <= 7 && 0 < ny && ny <= 7) {
                if (!visit[nx][ny] && graph[nx][ny] == 0) {
                    visit[nx][ny] = true;
                    solution(nx, ny);
                    visit[nx][ny] = false;
                }
            }
        }
    }
}
