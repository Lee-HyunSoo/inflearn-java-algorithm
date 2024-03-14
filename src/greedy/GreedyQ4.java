package greedy;

import java.util.*;

/**
 * 최대수입스케줄 (우선순위큐)
 */
public class GreedyQ4 {

    static class Pair implements Comparable<Pair> {
        int money, time;

        Pair(int money, int time) {
            this.money = money;
            this.time = time;
        }

        @Override
        public int compareTo(Pair p) {
            return p.time - this.time;
        }
    }

    static int n;
    static List<Pair> list = new ArrayList<>();

    public static void main(String[] args) {
        GreedyQ4 q = new GreedyQ4();
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int m = scan.nextInt();
            int d = scan.nextInt();
            list.add(new Pair(m, d));

            if (d > max) {
                max = d;
            }
        }

        int answer = q.solution(max);
        System.out.println(answer);
    }

    public int solution(int max) {
        int answer = 0;
        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int j = 0;
        for (int i = max; i > 0; i--) {
            for (; j < n; j++) {
                if (list.get(j).time < i) {
                    break;
                } else {
                    pq.offer(list.get(j).money);
                }
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        return answer;
    }
}
