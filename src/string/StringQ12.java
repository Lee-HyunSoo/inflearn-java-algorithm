package string;

import java.util.Scanner;

/**
 * 암호
 */
public class StringQ12 {

    public static void main(String[] args) {
        StringQ12 q = new StringQ12();

        Scanner scan = new Scanner(System.in);
        int input1 = scan.nextInt();
        scan.nextLine();
        String input2 = scan.nextLine();

        String answer = q.solution(input1, input2);
        System.out.println(answer);
    }

    public String solution(int input1, String input2) {
        String answer = "";

        for (int i = 0; i < input1; i++) {
            String tmp = input2.substring(0, 7)
                    .replace("#", "1")
                    .replace("*", "0");
            int binary = Integer.parseInt(tmp, 2);
            answer += (char) binary;

            input2 = input2.substring(7); // 이전 0 ~ 7 을 날리기 위해
        }

        return answer;
    }
}
