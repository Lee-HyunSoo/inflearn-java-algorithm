package DfsBfs;

import java.util.Scanner;

/**
 * 조합 구하기
 */
public class DBQ9 {

    static int n, m;
    static int[] combination;

    public static void main(String[] args) {
        DBQ9 q = new DBQ9();

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        combination = new int[m];
        q.solution(0, 1);
    }

    public void solution(int level, int idx) {
        if (level == m) {
            for (int i : combination) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = idx; i <= n; i++) {
                combination[level] = i;
                solution(level + 1, i + 1);
            }
        }
    }
}
