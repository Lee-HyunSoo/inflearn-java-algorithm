package RecursiveGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 그래프 최단거리 (BFS)
 */
public class RGQ12 {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visit;
    static int[] dist;


    public static void main(String[] args) {
        RGQ12 q = new RGQ12();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        dist = new int[n + 1];
        visit = new boolean[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            graph.get(x).add(y);
        }

        q.solution(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dist[i]);
        }
    }

    public void solution(int n) {
        Queue<Integer> q = new LinkedList<>();
        visit[n] = true;
        q.offer(n);
        dist[n] = 0;

        while (!q.isEmpty()) {
            int pos = q.poll();
            for (int i : graph.get(pos)) {
                if (!visit[i]) {
                    visit[i] = true;
                    q.offer(i);
                    dist[i] = dist[pos] + 1;
                }
            }
        }
    }
}
