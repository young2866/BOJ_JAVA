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
    static int TC;
    static int W;

    static int[] dist;
    static boolean[] visited;

    static List<Pair>[] p;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    static int INF = 1000000000;
    static boolean chk = false;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TC = sc.nextInt();

        for (int u = 0; u < TC; u++) {
            N = sc.nextInt();
            M = sc.nextInt();
            W = sc.nextInt();

            dist = new int[N + 1];
            Arrays.fill(dist, INF);
            p = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                p[i] = new ArrayList<>();
            }
            visited = new boolean[N + 1];

            for (int i = 0; i < M; i++) {
                int temp1 = sc.nextInt();
                int temp2 = sc.nextInt();
                int temp3 = sc.nextInt();

                p[temp1].add(new Pair(temp2, temp3));
                p[temp2].add(new Pair(temp1, temp3));
            }
            for (int i = 0; i < W; i++) {
                int temp1 = sc.nextInt();
                int temp2 = sc.nextInt();
                int temp3 = sc.nextInt();

                p[temp2].add(new Pair(temp1, -temp3));
            }
            chk = false;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dist[i] = 0;
                    for (int x = 1; x <= N; x++) {
                        for (int y = 1; y <= N; y++) {
                            for (Pair p : p[y]) {
                                int next = p.first; int d = p.second;
                                if (dist[y] > dist[next] + d) {
                                    visited[y] = true;
                                    dist[y] = dist[next] + d;
                                    if(x == N)
                                        chk = true;
                                }
                            }
                        }
                    }
                }
                if(chk)
                    break;
            }
            if (chk == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }


    }



}

