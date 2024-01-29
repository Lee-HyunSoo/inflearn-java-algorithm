package twoPointersAndSlidingWindow;

import java.util.Scanner;

/**
 * 최대 매출
 */
public class TwoPointSwQ3 {

    public static void main(String[] args) {
        TwoPointSwQ3 q = new TwoPointSwQ3();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        int answer = q.solution(n, k, arr);
        System.out.println(answer);

    }

    public int solution(int n, int k, int[] arr) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int answer = sum; // 이걸 하지 않으면 위에서 계산한 0~2번 배열의 값이 날아감
        for (int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
            answer = Math.max(sum, answer);
        }
        return answer;
    }
}
