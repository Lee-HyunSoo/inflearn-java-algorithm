package string;

import java.util.Scanner;

/**
 * 중복 문자 제거
 */
public class StringQ6 {

    public static void main(String[] args) {
        StringQ6 q = new StringQ6();

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String answer = q.solution(input);
        System.out.println(answer);
    }

    public String solution(String input) {
        String answer = "";
        for (int i = 0; i < input.length(); i++) {
            // indexOf 는 가장 첫 index 를 찾아준다.
            // 현재 index 와 글자로 찾은 index 가 같다면 처음 나온 글자, 다르면 이전에 나온 글자
            if (i == input.indexOf(input.charAt(i))) {
                answer += input.charAt(i);
            }
        }
        return answer;
    }
}
