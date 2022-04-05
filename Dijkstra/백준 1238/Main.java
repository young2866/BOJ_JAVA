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
            return Integer.compare(this.weight, p.weight);
        }
    }
    static int N;
    static int M;
    static int X;
    static boolean[] chk;
    static int[] D;
    static List<Pair>[] p;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    static int INF = Integer.MAX_VALUE;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        p = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            p[i] = new ArrayList<>();
        }
        M = sc.nextInt();
        X = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int temp1 = sc.nextInt();
            int temp2 = sc.nextInt();
            int temp3 = sc.nextInt();

            p[temp1].add(new Pair(temp2, temp3));
        }
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            Dijkstra(i);
            int temp = D[X];
            Dijkstra(X);
            temp += D[i];
            ans = Math.max(ans, temp);
        }

        System.out.println(ans);
    }

    public static void Dijkstra(int S) {
        chk = new boolean[N + 1];
        D = new int[N + 1];
        Arrays.fill(D, INF);

        D[S] = 0;
        pq.add(new Pair(S, 0));

        while (!pq.isEmpty()) {
            Pair curr_node = pq.poll();
            int cur_pos = curr_node.v;
            if(chk[cur_pos]) continue;
            chk[cur_pos] = true;

            for (Pair next : p[cur_pos]) {
                if (D[next.v] > D[cur_pos] + next.weight ) {
                    D[next.v] = D[cur_pos] + next.weight;
                    pq.add(new Pair(next.v,D[next.v]));
                }
            }

        }

    }

}

