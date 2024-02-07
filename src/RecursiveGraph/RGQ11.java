package RecursiveGraph;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 경로탐색 (인접리스트)
 */
public class RGQ11 {

    static int answer = 0;

    public static void main(String[] args) {
        RGQ11 q = new RGQ11();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            graph.get(x).add(y);
        }

        boolean[] visit = new boolean[n + 1];
        visit[1] = true;
        q.solution(graph, visit, n, 1);
        System.out.println(answer);
    }

    public void solution(ArrayList<ArrayList<Integer>> graph, boolean[] visit, int n, int row) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col : graph.get(row)) {
            if (!visit[col]) {
                visit[col] = true;
                solution(graph, visit, n, col);
                visit[col] = false;
            }
        }
    }
}
