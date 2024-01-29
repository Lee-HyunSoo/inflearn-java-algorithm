package array;

import java.util.Scanner;

/**
 * 격자판 최대합
 */
public class ArrayQ9 {

    public static void main(String[] args) {
        ArrayQ9 q = new ArrayQ9();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        int answer = q.solution(arr);
        System.out.println(answer);
    }

    public int solution(int[][] arr) {
        int answer = 0;

        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            // 대각선
            sum1 += arr[i][i];
            sum2 += arr[i][arr.length - 1 - i];

            // 가로, 세로
            int sum3 = 0, sum4 = 0;
            for (int j = 0; j < arr.length; j++) {
                sum3 += arr[i][j];
                sum4 += arr[j][i];
            }

            answer = Math.max(sum1, answer);
            answer = Math.max(sum2, answer);
            answer = Math.max(sum3, answer);
            answer = Math.max(sum4, answer);
        }

        return answer;
    }
}
