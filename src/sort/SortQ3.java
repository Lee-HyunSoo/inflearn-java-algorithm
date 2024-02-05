package sort;

import java.util.Scanner;

/**
 * 삽입 정렬
 */
public class SortQ3 {

    public static void main(String[] args) {
        SortQ3 q = new SortQ3();

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
        for (int i = 1; i < n; i++) {
            int tmp = arr[i], j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
    }
}