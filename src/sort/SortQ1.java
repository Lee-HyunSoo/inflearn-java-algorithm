package sort;

import java.util.Scanner;

/**
 * 선택 정렬
 */
public class SortQ1 {

    public static void main(String[] args) {
        SortQ1 q = new SortQ1();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        q.solution(n, arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public void solution(int n, int[] arr) {
        for (int i = 0; i < n; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[idx] > arr[j]) {
                    idx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
    }
}
