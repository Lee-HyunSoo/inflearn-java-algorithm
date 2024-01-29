package twoPointersAndSlidingWindow;

import java.util.Scanner;

/**
 * 연속 부분수열
 */
public class TwoPointSwQ4 {

    public static void main(String[] args) {
        TwoPointSwQ4 q = new TwoPointSwQ4();

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        int answer = q.solution(n, m, arr);
        System.out.println(answer);
    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0;

        int lt = 0, sum = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];

            if (sum == m) {
                answer++;
            }
            while (sum >= m) { // sum 이 m 보다 크면 lt 하나씩 감소
                sum -= arr[lt++];
                if (sum == m) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
