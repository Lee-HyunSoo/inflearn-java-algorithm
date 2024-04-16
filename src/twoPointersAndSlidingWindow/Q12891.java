package twoPointersAndSlidingWindow;

import java.util.Scanner;

/**
 * DNA 비밀번호
 */
public class Q12891 {

    static int[] count = new int[4]; // a, c, g, t
    static int[] per = new int[4];
    static int answer = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int s = scan.nextInt();
        int p = scan.nextInt();
        scan.nextLine();
        String dna = scan.nextLine();
        for (int i = 0; i < 4; i++) {
            count[i] = scan.nextInt();
        }

        int start = 0;
        int end = start + p;
        String pw = dna.substring(start, end);
        for (char c : pw.toCharArray()) {
            plus(c);
        }
        count();

        while (end < s) {
            minus(dna.charAt(start++));
            plus(dna.charAt(end++));
            count();
        }
        System.out.println(answer);
    }

    private static void count() {
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            if (per[i] < count[i]) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            answer++;
        }
    }

    private static void plus(char c) {
        if (c == 'A') {
            per[0]++;
        } else if (c == 'C') {
            per[1]++;
        } else if (c == 'G') {
            per[2]++;
        } else if (c == 'T') {
            per[3]++;
        }
    }

    private static void minus(char c) {
        if (c == 'A') {
            per[0]--;
        } else if (c == 'C') {
            per[1]--;
        } else if (c == 'G') {
            per[2]--;
        } else if (c == 'T') {
            per[3]--;
        }
    }
}
