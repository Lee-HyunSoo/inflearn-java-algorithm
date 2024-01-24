package string;

import java.util.Scanner;

/**
 * 유효한 팰린드롬
 */
public class StringQ8 {

    public static void main(String[] args) {
        StringQ8 q = new StringQ8();

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String answer = q.solution(input);
        System.out.println(answer);
    }

    public String solution(String input) {
        input = input.toUpperCase().replaceAll("[^A-Z]", ""); // ^ : 부정
        String reverse = new StringBuilder(input).reverse().toString();
        return input.equals(reverse) ?  "YES" : "NO";
    }
}
