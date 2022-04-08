import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.min;


public class Main {

    public static class Pair implements Comparable<Pair>{
        int first; int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair p) {
            return Long.compare(this.second, p.second);
        }
    }
    static int N;
    static int M;
    static int K;
    static boolean[] chk;

    static int[][] dist;
    static List<Integer>[] p;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int INF = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (c == 0) {
                dist[a][b] = 0;
                dist[b][a] = 1;
            } else {
                dist[a][b] = 0;
                dist[b][a] = 0;
            }
        }

        for (int i = 1; i <= N; i++) {
            dist[i][i] = 0;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(dist[a][b]);
        }

    }



}

