package array;

import java.util.Scanner;

/**
 * 임시반장 정하기
 */
public class ArrayQ11 {

    public static void main(String[] args) {
        ArrayQ11 q = new ArrayQ11();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[][] arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        int answer = q.solution(arr);
        System.out.println(answer);
    }

    public int solution(int[][] arr) {
        int answer = 0;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) { // i번째 학생
            int cnt = 0;
            for (int j = 0; j < arr.length; j++) { // j번째 학생
                for (int k = 0; k < 5; k++) { // k학년
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            System.out.println(cnt);
            if (cnt > max) {
                max = cnt;
                answer = i + 1;
            }
        }
        return answer;
    }
}
