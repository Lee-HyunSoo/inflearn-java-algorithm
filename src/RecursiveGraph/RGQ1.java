package RecursiveGraph;

import java.util.Scanner;

/**
 * 재귀함수
 */
public class RGQ1 {

    public static void main(String[] args) {
        RGQ1 q = new RGQ1();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        q.solution(n);
    }

    public void solution(int n) {
        if (n == 0) {
            return;
        }
        solution(n - 1);
        System.out.print(n + " ");
    }
}
