package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 원더랜드 (최소스패닝트리 : 크루스칼, Union Find 활용)
 */
public class GreedyQ7 {

    static class Edge implements Comparable<Edge> {
        int v1, v2, cost;

        Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }

    static int n, m;
    static int[] unf;
    static List<Edge> edges = new ArrayList<>();

    public static void main(String[] args) {
        GreedyQ7 q = new GreedyQ7();
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int z = scan.nextInt();
            edges.add(new Edge(x, y, z));
        }

        int answer = 0;
        Collections.sort(edges);
        for (Edge e : edges) {
            int fv1 = find(e.v1);
            int fv2 = find(e.v2);

            if (fv1 != fv2) {
                answer += e.cost;
                union(e.v1, e.v2);
            }
        }
        System.out.println(answer);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public static int find(int v) {
        if (v == unf[v]) {
            return v;
        } else {
            return unf[v] = find(unf[v]);
        }
    }
}
