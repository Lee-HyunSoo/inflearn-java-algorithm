package DfsBfs;

import java.util.*;

/**
 * 순열 구하기
 */
public class DBQ6 {

    static int n, m;
    static int[] arr;
    static boolean[] visit;
    static int[] permutation;

    public static void main(String[] args) {
        DBQ6 q = new DBQ6();

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        arr = new int[n];
        visit = new boolean[n];
        permutation = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        q.solution(0);
    }

    public void solution(int level) {
        if (level == m) {
            for (int i : permutation) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    permutation[level] = arr[i];
                    solution(level + 1);
                    visit[i] = false;
                }
            }
        }
    }
}
