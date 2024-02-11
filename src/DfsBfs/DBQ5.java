package DfsBfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 동전교환
 */
public class DBQ5 {

    static int n, m;
    static int answer = Integer.MAX_VALUE;
    static Integer[] coin;

    public static void main(String[] args) {
        DBQ5 q = new DBQ5();

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        coin = new Integer[n];
        for (int i = 0; i < n; i++) {
            coin[i] = scan.nextInt();
        }
        m = scan.nextInt();

        Arrays.sort(coin, Collections.reverseOrder()); // int 타입은 제네릭이 아니라서 정렬조건을 주려면 Integer 로 해야함
        q.solution(0, 0);
        System.out.println(answer);
    }

    public void solution(int idx, int changes) {
        if (changes > m || idx >= answer) {
            return;
        }
        if (changes == m) {
            answer = Math.min(answer, idx);
        } else {
            for (int i = 0; i < n; i++) {
                solution(idx + 1, changes + coin[i]);
            }
        }
    }
}
