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
    static int M;


    static long[] dist;

    static List<Pair>[] p;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    static long INF = Long.MAX_VALUE;
    static boolean chk = false;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        p = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = new ArrayList<>();
        }
        dist = new long[N + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i < M; i++) {
            int temp1 = sc.nextInt();
            int temp2 = sc.nextInt();
            int temp3 = sc.nextInt();

            p[temp1].add(new Pair(temp2, temp3));
        }

        dist[1] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (Pair p : p[j]) {
                    int next = p.first; int d = p.second;

                    if (dist[j] != INF && dist[next] > dist[j] + d) {
                        dist[next] = dist[j] + d;

                        if(i == N) chk = true;
                    }
                }
            }
        }
        if (chk) {
            System.out.println("-1");
        } else {
            for (int i = 2; i <= N; i++) {
                long temp = dist[i] != INF ? dist[i] : -1;
                System.out.println(temp);
            }
        }
    }



}

