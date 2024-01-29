package hashMapTreeSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 아나그램
 */
public class HmTsQ2 {

    public static void main(String[] args) {
        HmTsQ2 q = new HmTsQ2();

        Scanner scan = new Scanner(System.in);
        String input1 = scan.nextLine();
        String input2 = scan.nextLine();

        String answer = q.solution2(input1, input2);
        System.out.println(answer);
    }

    public String solution(String input1, String input2) {
        String answer = "YES";

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char c : input1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for (char c : input2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        for (char c : map1.keySet()) {
            if (!map2.containsKey(c)) {
                return "NO";
            } else if (map1.get(c) != map2.get(c)) {
                return "NO";
            }
        }
        return answer;
    }

    public String solution2(String input1, String input2) {
        String answer = "YES";

        Map<Character, Integer> map = new HashMap<>();
        for (char c : input1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : input2.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) { // c 가 없거나 글자수가 맞지 않을 경우
                return "NO";
            }
            map.put(c, map.get(c) - 1); // 글자 하나 찾으면 글자수 줄인다.
        }
        return answer;
    }
}
