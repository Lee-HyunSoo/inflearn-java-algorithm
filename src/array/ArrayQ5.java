package array;

import java.util.Scanner;

/**
 * 에라스토테네스 체
 */
public class ArrayQ5 {

    public static void main(String[] args) {
        ArrayQ5 q = new ArrayQ5();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int answer = q.solution(n);
        System.out.println(answer);
    }

    public int solution(int n) {
        int answer = 0;
        int[] prime = new int[n + 1];

        for (int i = 2; i < prime.length; i++) {
            if (prime[i] == 0) {
                answer++;
                for (int j = prime[i]; j < prime.length; j += i) { // += 으로 배수로 해야 타임아웃이 안난다.
                    prime[j] = 1;
                }
            }
        }
        return answer;
    }
}
