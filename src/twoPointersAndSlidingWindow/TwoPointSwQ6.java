package twoPointersAndSlidingWindow;

import java.util.Scanner;

/**
 * 최대 길이 연속부분수열
 */
public class TwoPointSwQ6 {

    public static void main(String[] args) {
        TwoPointSwQ6 q = new TwoPointSwQ6();

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int answer = q.solution(n, k , arr);
        System.out.println(answer);
    }

    public int solution(int n, int k, int[] arr) {
        int answer = 0;

        // rt는 0을 만나면 1로, lt는 0을 만나면 0 -> 1이 된 값을 1 -> 0으로 다시 바꾸는 개념
        int lt = 0, cnt = 0, length = 0;
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) { // 0을 만나면 1로 바꾸기 위해 cnt++
                cnt++;
                while (cnt > k) { // cnt 가 허용치를 넘겼다면
                    if (arr[lt] == 0) { // lt가 0을 만나면 1 -> 0 이 되므로 cnt--
                        cnt--;
                    }
                    lt++; // 0을 만날때까지 lt++, 1 -> 0 이 되면 길이가 하나 줄어야하기 때문에 if문 이후에 나와야한다.
                }
            }
            length = rt - lt + 1;
            answer = Math.max(answer, length);
        }
        return answer;
    }
}
