package array;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 뒤집은 소수
 */
public class ArrayQ6 {

    public static void main(String[] args) {
        ArrayQ6 q = new ArrayQ6();

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

    public boolean[] isPrime() {
        boolean[] prime = new boolean[100001];
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) {
                for (int j = i; j < prime.length; j += i) {
                    prime[j] = true;
                }
                prime[i] = false;
            }
        }
        return prime;
    }

    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        boolean[] prime = isPrime();

        for (int i : arr) {
            String reverse = new StringBuilder(String.valueOf(i)).reverse().toString();
            int num = Integer.parseInt(reverse);
            if (!prime[num]) {
                answer.add(num);
            }
        }
        return answer;
    }
}
