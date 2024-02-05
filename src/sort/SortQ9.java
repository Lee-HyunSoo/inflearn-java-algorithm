package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 뮤직비디오
 */
public class SortQ9 {

    public static void main(String[] args) {
        SortQ9 q = new SortQ9();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int answer = q.solution(n, m, arr);
        System.out.println(answer);
    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0;

        int lt = Arrays.stream(arr)
                .max()
                .getAsInt();
        int rt = Arrays.stream(arr)
                .sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }

    // 해당 용량에 총 몇장이 나오는지
    public int count(int[] arr, int capacity) {
        int cnt = 1, sum = 0; // cnt 가 1이어야 다하고 마지막 남은 장수들을 더해준다.
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= capacity) {
                sum += arr[i];
            } else {
                sum = arr[i]; // 현재의 값을 더했을 시 초과되면, 현재 값부터 다시 더하기 위해
                cnt++;
            }
        }
        return cnt;
    }
}