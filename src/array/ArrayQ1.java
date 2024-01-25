package array;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 큰 수 출력하기
 */
public class ArrayQ1 {

    public static void main(String[] args) {
        ArrayQ1 q = new ArrayQ1();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        ArrayList<Integer> answer = q.solution(arr);
        for (Integer i : answer) {
            System.out.print(i + " ");
        }
    }

    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                answer.add(arr[i]);
            }
        }
        return answer;
    }
}
