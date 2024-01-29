package hashMapTreeSet;

import java.util.*;

/**
 * K번째 큰 수
 */
public class HmTsQ5 {

    public static void main(String[] args) {
        HmTsQ5 q = new HmTsQ5();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        int answer = q.solution(n, k, arr);
        System.out.println(answer);
    }

    public int solution(int n, int k, int[] arr) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder()); // 내림차순 정렬, 없으면 기본으로 오름차순

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // 같은 것을 고르면 안되기 때문에 + 1 부터 시작
                for (int z = j + 1; z < n; z++) {
                    set.add(arr[i] + arr[j] + arr[z]);
                }
            }
        }

        int cnt = 0;
        for (int answer : set) {
            cnt++;
            if (cnt == k) {
                return answer;
            }
        }
        return -1;
    }
}
