package twoPointersAndSlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 공통 원소 구하기
 */
public class TwoPointSwQ2 {

    public static void main(String[] args) {
        TwoPointSwQ2 q = new TwoPointSwQ2();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scan.nextInt();
        }

        int m = scan.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = scan.nextInt();
        }

        ArrayList<Integer> answer = q.solution(arr1, arr2, n, m);
        for (Integer i : answer) {
            System.out.print(i + " ");
        }
    }

    public ArrayList<Integer> solution(int[] arr1, int[] arr2, int n, int m) {
        ArrayList<Integer> answer = new ArrayList<>();

        // two pointers 는 정렬이 되어있어야 쓸 수 있다.
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (arr1[p1] == arr2[p2]) {
                answer.add(arr1[p1]);
                p1++;
                p2++;
            } else if (arr1[p1] < arr2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        return answer;
    }
}
