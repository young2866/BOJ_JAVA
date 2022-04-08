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
    static boolean chk = false;

    static int[][] dist;
    static boolean[][] erase;
    static List<Integer>[] p;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int INF = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        dist = new int[N][N];
        erase = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int temp = INF;
                for (int k = 0; k < N; k++)
                    if(i != k && j != k) temp = min(temp, dist[i][k] + dist[k][j]);
                if (temp < dist[i][j])
                    chk = true;
                if(temp == dist[i][j]) erase[i][j] = true;
            }
        }
        int sum = 0;
        if (chk == true) {
            System.out.println("-1");
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!erase[i][j]) {
                        sum += dist[i][j];
                    }
                }
            }
            System.out.println(sum/2);
        }

    }



}

