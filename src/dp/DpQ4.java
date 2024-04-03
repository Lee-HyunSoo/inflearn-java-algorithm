package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 가장 높은 탑 쌓기
 */
public class DpQ4 {

    static class Rock implements Comparable<Rock> {
        int area;
        int height;
        int weight;

        public Rock(int area, int height, int weight) {
            this.area = area;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Rock rock) {
            return rock.area - this.area;
        }
    }

    static List<Rock> rocks = new ArrayList<>();
    static int[] dp;

    public static void main(String[] args) {
        DpQ4 q = new DpQ4();
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            int area = scan.nextInt();
            int height = scan.nextInt();
            int weight = scan.nextInt();
            rocks.add(new Rock(area, height, weight));
        }
        System.out.println(q.solution(n));
    }

    public int solution(int n) {
        // 밑면 넓은거 위에 좁은거
        // 무게 무거운거 위에 적은거
        // 밑면이 더 넓고 무게가 더 무거워야 아래로 들어갈 수 있음

        Collections.sort(rocks);

        dp[0] = rocks.get(0).height;
        int answer = dp[0];

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (rocks.get(j).weight > rocks.get(i).weight && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + rocks.get(i).height;
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}
