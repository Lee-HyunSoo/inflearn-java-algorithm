package stackQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 크레인 인형뽑기
 */
public class StackQueueQ3 {

    public static void main(String[] args) {
        StackQueueQ3 q = new StackQueueQ3();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scan.nextInt();
            }
        }
        int m = scan.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = scan.nextInt();
        }

        int answer = q.solution(n, m, board, moves);
        System.out.println(answer);
    }

    public int solution(int n, int m, int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            int pos = move - 1;
            for (int i = 0; i < n; i++) {
                if (board[i][pos] != 0) {
                    int tmp = board[i][pos];
                    board[i][pos] = 0;

                    if (!stack.isEmpty() && tmp == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(tmp);
                    }
                    break;
                }
            }
        }
        return answer;
    }
}
