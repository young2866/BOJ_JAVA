import java.util.*;

import static java.lang.Math.min;


public class Main {

    public static class Pair implements Comparable<Pair>{
        int v; long weight;

        public Pair(int v, long weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair p) {
            return Long.compare(this.weight, p.weight);
        }
    }
    static int N;
    static int M;
    static int D;
    static int E;

    static long[][] dist;

    static List<Pair>[] p;
    static int[] H;
    static boolean[] chk;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    static long INF = Long.MAX_VALUE;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 노드 갯수
        M = sc.nextInt(); // 간선 갯수
        D = sc.nextInt(); // 거리 비레 체력 소모량
        E = sc.nextInt(); // 높이 비례 성취감 획득량


        H = new int[N + 1];
        dist = new long[2][N + 1];

        for (int i = 0; i < 2; i++) {
            Arrays.fill(dist[i], INF);
        }
        p = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = new ArrayList<>();
        }


        for (int i = 1; i <= N; i++) {
            H[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            int temp1 = sc.nextInt();
            int temp2 = sc.nextInt();
            int temp3 = sc.nextInt();
            if(H[temp1] < H[temp2])
            p[temp1].add(new Pair(temp2, temp3));
            if(H[temp1] > H[temp2])
            p[temp2].add(new Pair(temp1, temp3));
        }

        for (int i = 0; i < 2; i++) {
            int S = (i > 0 ? N : 1);


            dist[i][S] = 0;
            chk = new boolean[N + 1];
            pq.add(new Pair(S, 0));

            while (!pq.isEmpty()) {
                Pair curr_node = pq.poll();
                int curr_pos = curr_node.v;
                if(chk[curr_pos]) break;
                chk[curr_pos] = true;

                for (Pair next : p[curr_pos]) {
                    int next_pos = next.v; long next_d = next.weight;
                    if (dist[i][curr_pos] + next_d < dist[i][next_pos]) {
                        dist[i][next_pos] = dist[i][curr_pos] + next_d;
                        pq.add(new Pair(next_pos, dist[i][next_pos]));
                    }
                }
            }
        }
        long result = -INF;

        for (int i = 1; i <= N; i++) {
            if (dist[0][i] < INF && dist[1][i] < INF) {
                result = Math.max(1L*H[i] * E - (dist[0][i] + dist[1][i]) * D, result);
            }
        }
        if(result == -INF) System.out.println("Impossible");
        else System.out.println(result);
    }



}

