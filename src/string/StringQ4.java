package string;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 단어 뒤집기
 */
public class StringQ4 {

    public static void main(String[] args) {
        StringQ4 q = new StringQ4();

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        scan.nextLine();

        String[] words = new String[input];
        for (int i = 0; i < input; i++) {
            String word = scan.nextLine();
            words[i] = word;
        }

//        String[] answer = q.solution(words);
        ArrayList<String> answer = q.solution2(words);
        for (String s : answer) {
            System.out.println(s);
        }
    }

    public String[] solution(String[] input) {
        for (int i = 0; i < input.length; i++) {
            String tmp = "";
            for (int j = input[i].length() - 1; j >= 0; j--) {
                tmp += input[i].charAt(j);
            }
            input[i] = tmp;
        }
        return input;
    }

    /**
     * String 은 불변이다 -> 기존의 값을 수정할 수 없다.
     * 때문에 String 끼리 연산 시 (더하기, replace ... ) 새로운 객체가 생성된다.
     * 반면 StringBuilder 는 연산 시 기존의 객체를 활용한다. -> 메모리 낭비가 적다.
     */
    public ArrayList<String> solution2(String[] input) {
        ArrayList<String> answer = new ArrayList<>();

        for (String s : input) {
            String tmp = new StringBuilder(s).reverse().toString();
            answer.add(tmp);
        }
        return answer;
    }
}
