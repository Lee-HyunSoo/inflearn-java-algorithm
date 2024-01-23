package string;

import java.util.Scanner;

/**
 * 대소문자 변환
 */
public class StringQ2 {

    public static void main(String[] args) {
        StringQ2 q2 = new StringQ2();

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String answer = q2.solution(input);
        System.out.println(answer);
    }

    public String solution(String input) {
        String answer = "";
        for (char c : input.toCharArray()) {
            if (Character.isLowerCase(c)) {
                answer += Character.toUpperCase(c);
            } else {
                answer += Character.toLowerCase(c);
            }
        }
        return answer;
    }
}
