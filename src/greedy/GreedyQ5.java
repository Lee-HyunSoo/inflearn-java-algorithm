package greedy;

import java.util.*;

/**
 * 다익스트라 알고리즘
 */
public class GreedyQ5 {

    static class Edge implements Comparable<Edge> {
        int vertex;
        int cost;

        Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }

    static int n, m;
    static List<List<Edge>> graph = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) {
        GreedyQ5 q = new GreedyQ5();
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for (int i = 0; i < m; i++) {
            graph.add(new ArrayList<>());
        }

        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            graph.get(a).add(new Edge(b, c));
        }

        q.solution(1);
        for (int i = 2; i <= n; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                System.out.println(i + " : " + dist[i]);
            } else {
                System.out.println(i + " : impossible");
            }
        }
    }

    public void solution(int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));
        dist[v] = 0;

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int nowVertex = e.vertex; // 현재 선택 된 정점
            int nowCost = e.cost; // nowVertex 까지 가는데 드는 비용

            if (nowCost > dist[nowVertex]) {
                continue;
            }
            for (Edge edge : graph.get(nowVertex)) {
                int newCost = nowCost + edge.cost;
                if (dist[edge.vertex] > newCost) {
                    dist[edge.vertex] = newCost;
                    pq.offer(new Edge(edge.vertex, newCost));
                }
            }
        }
    }
}
