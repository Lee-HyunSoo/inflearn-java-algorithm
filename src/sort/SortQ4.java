package sort;

import java.util.Scanner;

/**
 * LRU
 */
public class SortQ4 {

    public static void main(String[] args) {
        SortQ4 q = new SortQ4();

        Scanner scan = new Scanner(System.in);
        int s = scan.nextInt();
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int[] answer = q.solution(s, n, arr);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(int s, int n, int[] arr) {
        int[] answer = new int[s];

        for (int num : arr) {
            int idx = s - 1; // 초기값 = 캐시의 크기
            for (int i = 0; i < s; i++) {
                if (answer[i] == num) {
                    idx = i; // cache heat
                    break;
                }
            }

            // cache miss, heat 둘 다 현재 위치에서 -- 로 반복문을 돌며 한칸씩 뒤로 밀음
            // 0번에 가장 최근의 작업을 가져오기 위해
            for (int i = idx; i >= 1; i--) {
                answer[i] = answer[i - 1];
            }
            answer[0] = num;
        }
        return answer;
    }
}