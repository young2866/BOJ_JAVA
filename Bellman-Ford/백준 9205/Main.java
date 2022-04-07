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
    static int T;
    static int N;
    static boolean[] chk;

    static int[] x;
    static int[] y;
    static int[][] dist;
    static List<Integer>[] p;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int INF = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int u = 0; u < T; u++) {
            N = sc.nextInt();
            x = new int[N + 2];
            y = new int[N + 2];
            dist = new int[N + 2][N + 2];

            for (int i = 0; i < N + 2; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                x[i] = a;
                y[i] = b;
            }

            for (int i = 0; i < N + 2; i++) {
                for (int j = 0; j < N + 2; j++) {
                    int d = abs(x[i] - x[j]) + abs(y[i] - y[j]);

                    dist[i][j] = (d <= 1000 ? 1 : INF);
                }
            }

            for (int k = 0; k < N + 2; k++) {
                for (int i = 0; i < N + 2; i++) {
                    for (int j = 0; j < N + 2; j++) {
                        dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }

            if (dist[0][N + 1] == INF) {
                System.out.println("sad");
            } else {
                System.out.println("happy");
            }
        }


    }



}

