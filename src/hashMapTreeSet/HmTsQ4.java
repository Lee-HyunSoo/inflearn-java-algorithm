package hashMapTreeSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 모든 아나그램 찾기
 */
public class HmTsQ4 {

    public static void main(String[] args) {
        HmTsQ4 q = new HmTsQ4();

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String t = scan.nextLine();

        int answer = q.solution(s, t);
        System.out.println(answer);
    }

    public int solution(String s, String t) {
        int answer = 0;

        Map<Character, Integer> anagram = new HashMap<>();
        for (char c : t.toCharArray()) {
            anagram.put(c, anagram.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length() - 1; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int lt = 0;
        for (int rt = t.length() - 1; rt < s.length(); rt++) { // t.length() - 1 을 통해 시작하자마자 검증 가능
            map.put(s.charAt(rt), map.getOrDefault(s.charAt(rt), 0 ) + 1);
            if (map.equals(anagram)) {
                answer++;
            }

            map.put(s.charAt(lt), map.get(s.charAt(lt)) - 1);
            if (map.get(s.charAt(lt)) == 0) {
                map.remove(s.charAt(lt));
            }
            lt++;
        }
        return answer;
    }
}
