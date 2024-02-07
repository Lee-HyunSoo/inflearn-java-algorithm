package RecursiveGraph;

import java.util.Scanner;

/**
 * 부분집합 구하기
 */
public class RGQ6 {

    static int n;
    static int[] arr;

    public static void main(String[] args) {
        RGQ6 q = new RGQ6();

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arr = new int[n + 1];
        q.solution(1);
    }

    public void solution(int l) {
        if (l == n + 1) {
            for (int i = 1; i <= n; i++) {
                if (arr[i] != 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
            arr[l] = 1;
            solution(l + 1);
            arr[l] = 0;
            solution(l + 1);
        }
    }
}
