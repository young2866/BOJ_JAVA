import java.util.*;

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
    static int K;
    static int S;

    static int[][] dist;
    static List<Pair>[] p;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    static int INF = 1000000000;
    static int MIN = 1000000000;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 0; i < K; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            dist[a][b] = 1;
        }

        S = sc.nextInt();

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][k] + dist[k][j] == 2) {
                        dist[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < S; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (dist[a][b] == 1) {
                System.out.println("-1");
            } else if (dist[b][a] == 1) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }


    }



}

