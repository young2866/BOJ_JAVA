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
    static int V;
    static int E;
    static boolean[] chk;

    static int[][] dist;
    static List<Integer>[] p;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int INF = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();

        dist = new int[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            dist[a][b] = c;
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int MIN = INF;
        for (int i = 1; i <= V; i++) {
            MIN = min(MIN, dist[i][i]);
        }
        if(MIN == INF) System.out.println("-1");
        else System.out.println(MIN);
    }



}

