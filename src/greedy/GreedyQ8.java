package greedy;

import java.util.*;

/**
 * 원더랜드 (최소스패닝트리 : 프림, PriorityQueue 활용)
 */
public class GreedyQ8 {

    static class Edge implements Comparable<Edge> {
        int v, cost;

        Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }

    static int n, m;
    static boolean[] visit;
    static List<List<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) {
        GreedyQ8 q = new GreedyQ8();
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int z = scan.nextInt();
            graph.get(x).add(new Edge(y, z));
            graph.get(y).add(new Edge(x, z));
        }

        int answer = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int endVertex = e.v;
            if (!visit[endVertex]) {
                visit[endVertex] = true;
                answer += e.cost;
                for (Edge edge : graph.get(endVertex)) {
                    if (!visit[edge.v]) {
                        pq.offer(new Edge(edge.v, edge.cost));
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
