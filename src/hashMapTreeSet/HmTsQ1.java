package hashMapTreeSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 학급 회장
 */
public class HmTsQ1 {

    public static void main(String[] args) {
        HmTsQ1 q = new HmTsQ1();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String input = scan.nextLine();

        char answer = q.solution(n, input);
        System.out.println(answer);
    }

    public char solution(int n, String input) {
        char answer = ' ';
        Map<Character, Integer> map = new HashMap<>();

        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1); // value 가 없으면 0을 return
        }

        int max = 0;
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }
}
