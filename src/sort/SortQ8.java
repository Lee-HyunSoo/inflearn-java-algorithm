package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 이분검색
 */
public class SortQ8 {

    public static void main(String[] args) {
        SortQ8 q = new SortQ8();

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
        Arrays.sort(arr);

        int lt = 0, rt = n - 1;
        while (lt <= rt) { // 계속 더하다보면 lt 가 언젠가 rt 보다 커진다. 그 때 break
            int mid = (lt + rt) / 2;

            if (arr[mid] == m) {
                answer = mid + 1;
                break;
            } else if (arr[mid] > m) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }
}