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
            return Integer.compare(p.v, this.v);
        }
    }
    static int N = 1;
    static boolean[][] chk;
    static int[][] D;
    static int[][] p;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    static int INF = Integer.MAX_VALUE;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 1;
        while (true) {
            N = sc.nextInt();
            if (N == 0) {
                break;
            }
            p = new int[N][N];
            D = new int[N][N];
            chk = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    p[i][j] = sc.nextInt();
                    D[i][j] = INF;
                }
            }
            D[0][0] = p[0][0];
            pq.add(new Pair(0, 0));
            while (!pq.isEmpty()) {
                Pair temp = pq.poll();
                int temp_x = temp.v;
                int temp_y = temp.weight;

                for (int i = 0; i < 4; i++) {
                    int d_x = temp_x + dx[i];
                    int d_y = temp_y + dy[i];

                    if(d_x < 0 || d_x >= N || d_y < 0 || d_y >=N || chk[d_x][d_y]) continue;
                    if (D[d_x][d_y] > D[temp_x][temp_y] + p[d_x][d_y]) {
                        D[d_x][d_y] = D[temp_x][temp_y] + p[d_x][d_y];
                        pq.add(new Pair(d_x, d_y));
                    }
                }
            }
            System.out.println("Problem " + count + ": " + D[N-1][N-1] );
            count++;
        }
    }


}

