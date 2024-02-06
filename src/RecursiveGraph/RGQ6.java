package RecursiveGraph;

import java.util.Scanner;

/**
 * 부분집합 구하기
 */
public class RGQ6 {


    public static void main(String[] args) {
        RGQ6 q = new RGQ6();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int start = 1;
        q.solution(start, n);
    }

    public void solution(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i);
        }
    }
}
