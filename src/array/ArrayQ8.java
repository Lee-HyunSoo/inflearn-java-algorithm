package array;

import java.util.Scanner;

/**
 * 등수 구하기
 */
public class ArrayQ8 {

    public static void main(String[] args) {
        ArrayQ8 q = new ArrayQ8();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        int[] answer = q.solution(arr);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int cnt = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    cnt++;
                }
            }
            answer[i] = cnt + 1;
        }
        return answer;
    }
}
