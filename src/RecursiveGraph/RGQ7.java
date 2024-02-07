package RecursiveGraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 이진트리 레벨탐색
 */
public class RGQ7 {

    static class Node {
        int data;
        Node lt, rt;

        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }

    public static void main(String[] args) {
        RGQ7 q = new RGQ7();

        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        q.solution(root);
    }

    public void solution(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int l = 0; // level

        while (!q.isEmpty()) {
            System.out.print(l + " : ");
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node node = q.poll();
                System.out.print(node.data + " ");
                if (node.lt != null) {
                    q.offer(node.lt);
                }
                if (node.rt != null) {
                    q.offer(node.rt);
                }
            }
            l++;
            System.out.println();
        }
    }
}
