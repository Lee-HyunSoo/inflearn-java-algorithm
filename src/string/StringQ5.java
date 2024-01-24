package string;

import java.util.Scanner;

/**
 * 특정 문자 뒤집기
 */
public class StringQ5 {

    public static void main(String[] args) {
        StringQ5 q = new StringQ5();

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String answer = q.solution(input);
        System.out.println(answer);
    }

    public String solution(String input) {
        char[] answer = input.toCharArray();
        int lt = 0, rt = answer.length - 1;

        while (lt < rt) {
            if (!Character.isAlphabetic(answer[lt])) {
                lt++; // 맨 왼쪽이 알파벳이 아닐 경우 ++
            } else if (!Character.isAlphabetic(answer[rt])) {
                rt--; // 맨 오른쪽이 알파벳이 아닐 경우 --
            } else {
                // 둘다 알파벳인 경우
                char c = answer[lt];
                answer[lt] = answer[rt];
                answer[rt] = c;
                lt++;
                rt--;
            }
        }
        return String.valueOf(answer);
    }
}
