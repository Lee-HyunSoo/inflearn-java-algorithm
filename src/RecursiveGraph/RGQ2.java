package RecursiveGraph;

import java.util.Scanner;

/**
 * 이진수 출력
 */
public class RGQ2 {

    public static void main(String[] args) {
        RGQ2 q = new RGQ2();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        q.solution(n);
    }

    public void solution(int n) {
        if (n > 1) {
            solution(n / 2);
        }
        System.out.print(n % 2);
    }
}
