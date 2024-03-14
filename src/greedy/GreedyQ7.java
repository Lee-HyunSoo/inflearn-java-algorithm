package greedy;

import java.util.Scanner;

/**
 * 원더랜드 (최소스패닝트리 : 크루스칼, Union Find 활용)
 */
public class GreedyQ7 {

    static int n, m;
    static int[] unf;

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
            union(x, y);
        }

        int a = scan.nextInt();
        int b = scan.nextInt();
        int fa = find(a);
        int fb = find(b);

        String answer = fa == fb ? "YES" : "NO";
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
