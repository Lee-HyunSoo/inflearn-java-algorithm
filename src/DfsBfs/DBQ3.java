package DfsBfs;

import java.util.Scanner;

/**
 * 최대점수 구하기
 */
public class DBQ3 {

    static int[] score;
    static int[] time;
    static int answer = 0;
    static int sum1, sum2 = 0;

    public static void main(String[] args) {
        DBQ3 q = new DBQ3();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        score = new int[n];
        time = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = scan.nextInt();
            time[i] = scan.nextInt();
        }

        q.solution(m, 0);
        System.out.println(answer);
    }

    public void solution(int limit, int idx) {
        if (sum2 > limit) {
            return;
        }
        if (idx == score.length) {
            answer = Math.max(answer, sum1);
        } else {
            sum1 += score[idx];
            sum2 += time[idx];
            solution(limit, idx + 1);
            sum1 -= score[idx];
            sum2 -= time[idx];
            solution(limit, idx + 1);
        }
    }
}
