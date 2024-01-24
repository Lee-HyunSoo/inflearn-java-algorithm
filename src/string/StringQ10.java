package string;

import java.util.Scanner;

/**
 * 가장 짧은 문자거리
 */
public class StringQ10 {

    public static void main(String[] args) {
        StringQ10 q = new StringQ10();

        Scanner scan = new Scanner(System.in);
        String input1 = scan.next();
        char input2 = scan.next().charAt(0);

        int[] answer = q.solution(input1, input2);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(String input1, char input2) {
        int[] answer = new int[input1.length()];

        // -> 로 가면서 input2 이면 거리 0, 아니면 기존거리 + 1
        int distance = 1000;
        for (int i = 0; i < input1.length(); i++) {
            if (input1.charAt(i) == input2) {
                distance = 0;
                answer[i] = distance;
            } else {
                answer[i] = ++distance;
            }
        }

        // <- 로 오면서 input2 이면 거리 0, 아니면 answer[i] 와 기존거리 + 1을 비교해 더 작은값 대입
        distance = 1000;
        for (int i = input1.length() - 1; i >= 0; i--) {
            if (input1.charAt(i) == input2) {
                distance = 0;
                answer[i] = distance; // 없어도 되긴한다. 이미 0이 대입 되어있기 때문
            } else {
                answer[i] = Math.min(answer[i], ++distance);
            }
        }
        return answer;
    }
}
