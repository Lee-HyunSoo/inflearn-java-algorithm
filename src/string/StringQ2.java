package string;

import java.util.Scanner;

/**
 * 대소문자 변환
 */
public class StringQ2 {

    public static void main(String[] args) {
        StringQ2 q = new StringQ2();

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String answer = q.solution2(input);
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

    /**
     * 아스키 코드
     * 대문자 : 65 ~ 90
     * 소문자 : 97 ~ 122
     * 대소문자 차이 : 32
     */
    public String solution2(String input) {
        String answer = "";
        for (char c : input.toCharArray()) {
            if (97 <= c && c <= 122) {
                answer += (char) (c - 32); // 소문자 -> 대문자
            } else {
                answer += (char) (c + 32); // 대문자 -> 소문자
            }
        }
        return answer;
    }
}
