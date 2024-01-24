package string;

import java.util.Scanner;

/**
 * 회문 문자열
 */
public class StringQ7 {

    public static void main(String[] args) {
        StringQ7 q = new StringQ7();

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String answer = q.solution2(input);
        System.out.println(answer);
    }

    public String solution(String input) {
        input = input.toUpperCase();
        int lt = 0, rt = input.length() - 1;

        while (lt < rt) {
            if (input.charAt(lt) == input.charAt(rt)) {
                lt++;
                rt--;
            } else {
                return "NO";
            }
        }
        return "YES";
    }

    public String solution2(String input) {
        String reverse = new StringBuilder(input).reverse().toString();
        return reverse.equalsIgnoreCase(input) ? "YES" : "NO"; // 대소문자 구별을 하지 않는 equalsIgnoreCase
    }
}
