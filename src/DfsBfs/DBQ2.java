package DfsBfs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 바둑이 승차
 */
public class DBQ2 {

    static int[] arr;
    static int sum = 0;
    static int answer = 0;

    public static void main(String[] args) {
        DBQ2 q = new DBQ2();

        Scanner scan = new Scanner(System.in);
        int c = scan.nextInt();
        int n = scan.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        q.solution(c, 0);
        System.out.println(answer);
    }

    public void solution(int weight, int idx) {
        if (sum > weight) {
            return;
        }
        if (idx == arr.length) {
            answer = Math.max(answer, sum);
        } else {
            sum += arr[idx];
            solution(weight, idx + 1);
            sum -= arr[idx];
            solution(weight, idx + 1);
        }
    }
}
