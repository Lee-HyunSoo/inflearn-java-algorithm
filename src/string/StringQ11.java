package string;

import java.util.Scanner;

/**
 * 문자열 압축
 */
public class StringQ11 {

    public static void main(String[] args) {
        StringQ11 q = new StringQ11();

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String answer = q.solution(input);
        System.out.println(answer);
    }

    public String solution(String input) {
        String answer = "";
        input += " "; // 공백으로 한글자를 늘려서 기존에 마지막이던 부분까지 탐색

        int cnt = 1;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                cnt++;
            } else {
                answer += input.charAt(i);
                if (cnt != 1) {
                    answer += String.valueOf(cnt);
                }
                cnt = 1;
            }
        }
        return answer;
    }

    public String solution2(String input) {
        String answer = "";
        int cnt = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                cnt++;
            } else {
                answer += input.charAt(i - 1);
                if (cnt != 1) {
                    answer += String.valueOf(cnt);
                }
                cnt = 1;
            }
        }

        answer += input.charAt(input.length() - 1);
        if (cnt != 1) {
            answer += String.valueOf(cnt);
        }

        return answer;
    }
}
