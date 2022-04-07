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
    static boolean[] chk;

    static int[][] dist;
    static List<Integer>[] p;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int INF = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            dist[a][b] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    if(dist[i][j] != INF) sum++;
                    else if(dist[j][i] != INF) sum++;
                }
            }
            if(sum == N - 1)
                count++;
        }
        System.out.println(count);

    }



}

