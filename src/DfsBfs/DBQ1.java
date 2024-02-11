package DfsBfs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 합이 같은 부분집합
 */
public class DBQ1 {

    static int[] arr;
    static String answer = "NO";
    static int total = 0;
    static int sum = 0;
    static boolean flag = false;

    public static void main(String[] args) {
        DBQ1 q = new DBQ1();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        total = Arrays.stream(arr).sum();

        q.solution2(0);
        System.out.println(answer);
    }

    public void solution(int idx) {
        if (flag) {
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            sum += arr[i];
            if (sum == total - sum) {
                answer = "YES";
                flag = true;
            }
            solution(idx + 1);
            sum -= arr[i];
        }
    }

    public void solution2(int idx) {
        if (flag || idx == arr.length) {
            return;
        }
        if (sum == total - sum) {
            answer = "YES";
            flag = true;
        } else {
            sum += arr[idx];
            solution2(idx + 1);
            sum -= arr[idx];
            solution2(idx + 1);
        }
    }
}
