package array;

import java.util.Scanner;

/**
 * 피보나치 수열
 */
public class ArrayQ4 {

    public static void main(String[] args) {
        ArrayQ4 q = new ArrayQ4();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] answer = q.solution(n);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;

        for (int i = 2; i < n; i++) {
            answer[i] = answer[i - 1] + answer[i - 2];
        }
        return answer;
    }
}
