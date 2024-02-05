package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 장난꾸러기
 */
public class SortQ6 {

    public static void main(String[] args) {
        SortQ6 q = new SortQ6();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        ArrayList<Integer> answer = q.solution(n, arr);
        for (Integer i : answer) {
            System.out.print(i + " ");
        }

    }

    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();
        Arrays.sort(tmp);

        for (int i = 0; i < n; i++) {
            if (arr[i] != tmp[i]) {
                answer.add(i + 1);
            }
        }
        return answer;
    }
}