package hashMapTreeSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 매출액의 종류
 */
public class HmTsQ3 {

    public static void main(String[] args) {
        HmTsQ3 q = new HmTsQ3();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        ArrayList<Integer> answer = q.solution(n, k, arr);
        for (Integer i : answer) {
            System.out.print(i + " ");
        }
    }

    public ArrayList<Integer> solution(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); // 1씩 count 하며 1~k-1번째 슬라이딩 윈도우
        }

        int lt = 0;
        for (int rt = k - 1; rt < arr.length; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1); // 같은 값이 있으면 1 추가
            answer.add(map.size()); // map 은 알아서 중복제거 해주므로 size
            map.put(arr[lt], map.get(arr[lt]) - 1); // 이전거를 빼기위해 -1
            if (map.get(arr[lt]) == 0) {
                map.remove(arr[lt]); // value 가 0 이면 삭제
            }
            lt++;
        }
        return answer;
    }
}
