package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 좌표 정렬
 */
public class SortQ7 {

    public static void main(String[] args) {
        SortQ7 q = new SortQ7();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Pair> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            answer.add(new Pair(x, y));
        }

        Collections.sort(answer);
        for (Pair p : answer) {
            System.out.println(p.x + " " + p.y);
        }
    }
}

class Pair implements Comparable<Pair> {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p) {
        if (this.x == p.x) {
            return this.y - p.y; // 결과가 음수면 오름차순
        } else {
            return this.x - p.x;
        }
    }
}
