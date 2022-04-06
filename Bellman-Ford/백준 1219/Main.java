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
    static int S;
    static int E;
    static int M;

    static long[] dist;
    static int[][] Possible;
    static List<Pair>[] p;
    static int[] cost;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    static long INF = 1L<<60;
    static boolean chk = false;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();
        E = sc.nextInt();
        M = sc.nextInt();

        cost = new int[N];
        dist = new long[N];
        Possible = new int[N][N];
        Arrays.fill(dist, INF);
        p = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            p[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            int C = sc.nextInt();

            p[S].add(new Pair(E, C));
            Possible[S][E] = 1;
        }
        for (int i = 0; i < N; i++) {
            cost[i] = sc.nextInt();
            Possible[i][i] = 1;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(Possible[i][k] == 1 && Possible[k][j] == 1) Possible[i][j] = 1;
                }
            }
        }

        dist[S] = -cost[S];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (Pair p : p[j]) {
                    int next = p.first; int d = p.second;
                    if (dist[j]!=INF && dist[next] > dist[j] + d - cost[next]) {
                        dist[next] = dist[j] + d - cost[next];
                        if(i == N-1 && Possible[next][E] == 1) chk = true;
                    }
                }
            }
        }

        if (chk) {
            System.out.println("Gee");
        } else if (dist[E] == INF) {
            System.out.println("gg");
        } else {
            System.out.println(-dist[E]);
        }
    }



}

