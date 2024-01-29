package twoPointersAndSlidingWindow;

import java.util.Scanner;

/**
 * 연속된 자연수의 합
 */
public class TwoPointSwQ5 {

    public static void main(String[] args) {
        TwoPointSwQ5 q = new TwoPointSwQ5();

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int answer = q.solution(n);
        System.out.println(answer);
    }

    public int solution(int n) {
        int answer = 0;

        int lt = 1, sum = lt;
        for (int rt = 2; rt < n; rt++) {
            sum += rt;

            if (sum == n) {
                answer++;
            }
            while (sum >= n) {
                sum -= lt++;
                if (sum == n) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
