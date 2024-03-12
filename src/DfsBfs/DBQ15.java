package DfsBfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 피자 배달 거리
 */
public class DBQ15 {

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static int[][] arr;
    static int[] combination;
    static List<Pair> house = new ArrayList<>();
    static List<Pair> pizza = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        DBQ15 q = new DBQ15();
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scan.nextInt();
                if (arr[i][j] == 1) {
                    house.add(new Pair(i, j));
                }
                if (arr[i][j] == 2) {
                    pizza.add(new Pair(i, j));
                }
            }
        }
        combination = new int[pizza.size()];
        q.solution(0, 0);
        System.out.println(answer);
    }

    public void solution(int idx, int start) {
        if (idx == m) {
            int sum = 0;
            for (Pair p1 : house) {
                int min = Integer.MAX_VALUE;
                for (int i : combination) {
                    Pair p2 = pizza.get(i);
                    int dist = Math.abs(p2.x - p1.x) + Math.abs(p2.y - p1.y);
                    min = Math.min(min, dist);
                }
                sum += min;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = start; i < pizza.size(); i++) {
                combination[idx] = i;
                solution(idx + 1, i + 1);
            }
        }
    }
}
