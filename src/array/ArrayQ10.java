package array;

import java.util.Scanner;

/**
 * 봉우리
 */
public class ArrayQ10 {

    public static void main(String[] args) {
        ArrayQ10 q = new ArrayQ10();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[][] arr = new int[n + 2][n + 2];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        int answer = q.solution(arr);
        System.out.println(answer);
    }

    public int solution(int[][] arr) {
        int answer = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - 1; j++) {

                if (arr[i - 1][j] < arr[i][j] && arr[i + 1][j] < arr[i][j] &&
                        arr[i][j - 1] < arr[i][j] && arr[i][j + 1] < arr[i][j]) {
                    answer++;
                }
            }
        }
        return answer;
    }
}