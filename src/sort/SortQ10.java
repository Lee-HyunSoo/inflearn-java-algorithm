package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 마구간 정하기
 */
public class SortQ10 {

    public static void main(String[] args) {
        SortQ10 q = new SortQ10();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int c = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int answer = q.solution(n, c, arr);
        System.out.println(answer);
    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n - 1];

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) >= m) { // count 가 m 보다 커야 answer 라고 볼 수 있다.
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return answer;
    }

    public int count(int[] arr, int mid) {
        int cnt = 1; // 1 이어야 첫 말을 세는 형태가 된다.
        int pos = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - pos >= mid) {
                cnt++;
                pos = arr[i];
            }
        }
        return cnt;
    }
}