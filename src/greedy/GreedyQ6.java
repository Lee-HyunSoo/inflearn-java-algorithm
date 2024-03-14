package greedy;

import java.util.*;

/**
 * 친구인가? (Disjoint-Set : Union&Find)
 */
public class GreedyQ6 {

    static int n, m;
    static int[] unf;

    public static void main(String[] args) {
        GreedyQ6 q = new GreedyQ6();
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
