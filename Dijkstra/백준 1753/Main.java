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
            return Integer.compare(this.weight,p.weight);
        }
    }
    static int V;
    static int E;
    static int K;
    static boolean[] chk;
    static List<Pair>[] p;
    static int[] D;
    static int INF = Integer.MAX_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();
        K = sc.nextInt();

        p = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            p[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            int temp1 = sc.nextInt();
            int temp2 = sc.nextInt();
            int temp3 = sc.nextInt();
            p[temp1].add(new Pair(temp2, temp3));
        }

        chk = new boolean[V + 1];
        D = new int[V + 1];
        Arrays.fill(D, INF);

        Dijkstra(K);
        for (int i = 1; i <= V; i++) {
            if(D[i] == INF) System.out.println("INF");
            else System.out.println(D[i]);

        }
    }

    public static void Dijkstra(int s) {
        pq.add(new Pair(s, 0));
        D[s] = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int cur = curr.v;
            if(chk[cur] == true) continue;
            chk[cur] = true;

            for (Pair p : p[cur]) {
                if (D[p.v] > D[cur] + p.weight) {
                    D[p.v] = D[cur] + p.weight;
                    pq.add(new Pair(p.v, D[p.v]));
                }
            }
        }
    }



}

