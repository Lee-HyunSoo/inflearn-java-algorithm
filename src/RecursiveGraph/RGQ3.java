package RecursiveGraph;

import java.util.Scanner;

/**
 * 팩토리얼
 */
public class RGQ3 {

    public static void main(String[] args) {
        RGQ3 q = new RGQ3();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int answer = q.solution(n);
        System.out.println(answer);
    }

    public int solution(int n) {
        if (n == 1) {
            return 1;
        }
        return n * solution(n - 1);
    }
}
