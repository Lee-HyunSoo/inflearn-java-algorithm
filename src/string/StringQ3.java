package string;

import java.util.Scanner;

/**
 * 문장 속 단어
 */
public class StringQ3 {

    public static void main(String[] args) {
        StringQ3 q = new StringQ3();

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String answer = q.solution2(input);
        System.out.println(answer);
    }

    public String solution(String input) {
        String[] split = input.split(" ");

        String answer = split[0];
        int length = split[0].length();
        for (String s : split) {
            if (s.length() > length) {
                length = s.length();
                answer = s;
            }
        }
        return answer;
    }

    public String solution2(String input) {
        String answer = "";
        int length = Integer.MIN_VALUE, pos;

        while ((pos = input.indexOf(" ")) != -1) { // 띄어쓰기의 위치 파악
            String tmp = input.substring(0, pos);
            int len = tmp.length();

            if (len > length) {
                length = len;
                answer = tmp;
            }
            input = input.substring(pos + 1); // 문자열 앞부분 자름
        }

        if (input.length() > length) {
            answer = input;
        }

        return answer;
    }
}
