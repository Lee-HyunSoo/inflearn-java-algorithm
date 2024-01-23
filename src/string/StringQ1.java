package string;

import java.util.Scanner;

/**
 * 문자 찾기
 */
public class StringQ1 {

    public static void main(String[] args) {
        StringQ1 q = new StringQ1();

        Scanner scan = new Scanner(System.in);
        String input1 = scan.nextLine();
        char input2 = scan.nextLine().charAt(0);

        int answer = q.solution(input1, input2);
        System.out.println(answer);
    }

    public int solution(String input1, char input2) {
        int answer = 0;
        input1 = input1.toUpperCase();
        input2 = Character.toUpperCase(input2);

        for (char c : input1.toCharArray()) {
            if (c == input2) {
                answer++;
            }
        }
        return answer;
    }
}
