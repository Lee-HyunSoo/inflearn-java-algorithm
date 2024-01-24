package string;

import java.util.Scanner;

/**
 * 숫자만 추출
 */
public class StringQ9 {

    public static void main(String[] args) {
        StringQ9 q = new StringQ9();

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        int answer = q.solution2(input);
        System.out.println(answer);
    }

    public int solution(String input) {
        input = input.toUpperCase().replaceAll("[A-Z]", "");
        return Integer.parseInt(input);
    }

    public int solution2(String input) {
        String answer = "";
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                answer += c;
            }
        }
        return Integer.parseInt(answer);
    }
}
