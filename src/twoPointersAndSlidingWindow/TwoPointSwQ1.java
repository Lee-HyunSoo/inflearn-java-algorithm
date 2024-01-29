package twoPointersAndSlidingWindow;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 두 배열 합치기
 */
public class TwoPointSwQ1 {

    public static void main(String[] args) {
        TwoPointSwQ1 q = new TwoPointSwQ1();

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

        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (arr1[p1] <= arr2[p2]) { // 일반적으로 작은쪽의 포인터를 증가시킨다.
                answer.add(arr1[p1++]);
            } else {
                answer.add(arr2[p2++]);
            }
        }

        while (p1 < arr1.length) {
            answer.add(arr1[p1++]);
        }
        while (p2 < arr2.length) {
            answer.add(arr2[p2++]);
        }
        return answer;
    }
}
