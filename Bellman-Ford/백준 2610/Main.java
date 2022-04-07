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
        p = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = new ArrayList<>();
        }
        chk = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        for (int i = 1; i <= N; i++) {
            dist[i][i] = 0;
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
            if (!chk[i]) {
                chk[i] = true;
                count++;
                p[count].add(i);
            }else continue;
            for (int j = 1; j <= N; j++) {
                if (i != j && dist[i][j] != INF) {
                    chk[j] = true;
                    p[count].add(j);
                }
            }
        }
        System.out.println(count);
        for (int i = 1; i <= count; i++) {
            int MIN = p[i].get(0);
            int temp = 999999999;
            for (int x = 0; x < p[i].size(); x++) {
                int sum = 0;
                for (int y = 0; y < p[i].size(); y++) {
                    if (x != y) {
                        sum = Math.max(dist[p[i].get(x)][p[i].get(y)],sum);
                    }
                }
                if (temp > sum) {
                    temp = sum;
                    MIN = p[i].get(x);
                }
            }
            pq.add(MIN);
        }
        for (int i = 0; i < count; i++) {
            int temp = pq.poll();
            System.out.println(temp);
        }
    }



}

