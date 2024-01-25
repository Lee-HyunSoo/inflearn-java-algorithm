package array;

import java.util.Scanner;

/**
 * 보이는 학생
 */
public class ArrayQ2 {

    public static void main(String[] args) {
        ArrayQ2 q = new ArrayQ2();

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
        int answer = 1;

        int student = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (student < arr[i]) {
                answer++;
                student = arr[i];
            }
        }
        return answer;
    }
}
