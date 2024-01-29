package array;

import java.util.Scanner;

/**
 * 점수 계산
 */
public class ArrayQ7 {

    public static void main(String[] args) {
        ArrayQ7 q = new ArrayQ7();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        int answer = q.solution(arr);
        System.out.println(answer);
    }

    public int solution(int[] arr) {
        int answer = 0;
        int[] score = new int[arr.length + 1]; // 누적합

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                score[i + 1] = score[i] + arr[i];
            }
            answer += score[i + 1];
        }
        return answer;
    }
}
