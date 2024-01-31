package sort;

import java.util.Scanner;

/**
 * 버블 정렬
 */
public class SortQ2 {

    public static void main(String[] args) {
        SortQ2 q = new SortQ2();

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
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}