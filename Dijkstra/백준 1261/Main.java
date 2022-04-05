import java.util.*;

import static java.lang.Math.min;


public class Main {

    public static class Pair implements Comparable<Pair>{
        int v, weight;

        public Pair(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair p) {
            return Integer.compare(this.weight, p.weight);
        }
    }
    static int N;
    static int M;
    static int[][] p;
    static int[][] D;
    static int[] d_x = {0, 0, -1, 1};
    static int[] d_y = {1, -1, 0, 0};
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    static int INF = Integer.MAX_VALUE;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        D = new int[N][M];
        p = new int[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(D[i], INF);
        }
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                p[i][j] = s.charAt(j) - '0';
            }
        }
        Dijkstra();
        System.out.println(D[N - 1][M - 1]);
    }

    public static void Dijkstra() {
        pq.add(new Pair(0, 0));
        D[0][0] = 0;

        while (!pq.isEmpty()) {
            Pair cur_node = pq.poll();
            int curr_x = cur_node.v;
            int curr_y = cur_node.weight;

            for (int i = 0; i < 4; i++) {
                int dx = curr_x + d_x[i];
                int dy = curr_y + d_y[i];

                if(dx < 0 || dx > N-1 || dy < 0 || dy > M-1) continue;
                if (D[dx][dy] > p[dx][dy] + D[curr_x][curr_y]) {
                    D[dx][dy] = p[dx][dy] + D[curr_x][curr_y];
                    pq.add(new Pair(dx, dy));
                }
            }

        }

    }

}

