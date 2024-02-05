package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 중복 확인
 */
public class SortQ5 {

    public static void main(String[] args) {
        SortQ5 q = new SortQ5();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        String answer = q.solution(n, arr);
        System.out.println(answer);
    }

    public String solution(int n, int[] arr) {
        String answer = "U";
        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return "D";
            }
        }
        return answer;
    }
}