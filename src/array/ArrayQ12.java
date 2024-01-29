package array;

import java.util.Scanner;

/**
 * 멘토링
 */
public class ArrayQ12 {

    public static void main(String[] args) {
        ArrayQ12 q = new ArrayQ12();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               arr[i][j] = scan.nextInt();
            }
        }

        int answer = q.solution(arr, m, n);
        System.out.println(answer);
    }

    public int solution(int[][] arr, int m, int n) {
        int answer = 0;
        int[][] cnt = new int[n][n];

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(cnt[i][j]);
            }
            System.out.println();
        }

        return answer;
    }
}
