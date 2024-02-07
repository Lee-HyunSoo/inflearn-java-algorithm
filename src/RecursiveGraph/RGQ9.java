package RecursiveGraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Tree 말단노드까지의 가장 짧은 경로
 */
public class RGQ9 {

    static int answer = Integer.MAX_VALUE;

    static class Node {
        int data;
        Node lt, rt;

        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }

    public static void main(String[] args) {
        RGQ9 q = new RGQ9();

        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        int answer = q.solution(root, 0);
        System.out.println(answer);
    }

    public int solution(Node node, int dist) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Node n = q.poll();
                if (n.lt == null && n.rt == null) {
                    return answer;
                }
                if (n.lt != null) {
                    q.offer(n.lt);
                }
                if (n.rt != null) {
                    q.offer(n.rt);
                }
            }
            answer++;
        }
        return answer;
    }
}
