package RecursiveGraph;


/**
 * 이진트리 순회
 */
public class RGQ5 {

    static class Node {
        int data;
        Node lt, rt;

        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }

    public static void main(String[] args) {
        RGQ5 q = new RGQ5();

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
        if (root == null) { // null 인 경우 말단 노드
            return;
        }
        System.out.print(root.data + " "); // 전위 순회
        solution(root.lt);
        System.out.print(root.data + " "); // 중위 순회
        solution(root.rt);
        System.out.print(root.data + " "); // 후위 순회
    }
}
