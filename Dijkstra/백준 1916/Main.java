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
    static int N;
    static int M;
    static boolean[] chk;
    static int[] D;
    static List<Pair>[] p;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    static int S, E;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        chk = new boolean[N + 1];
        D = new int[N + 1];
        Arrays.fill(D, INF);
        p = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++)
            p[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int temp1 = sc.nextInt();
            int temp2 = sc.nextInt();
            int temp3 = sc.nextInt();

            p[temp1].add(new Pair(temp2, temp3));
        }
        S = sc.nextInt();
        E = sc.nextInt();

        Dijkstra(S);
        System.out.println(D[E]);

    }

    public static void Dijkstra(int s) {
        D[s] = 0;
        pq.add(new Pair(s, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int cur = curr.v;

            if(chk[cur] == true) continue;
            chk[cur] = true;

            for (Pair p : p[cur]) {
                if (D[p.v] > D[cur] + p.weight) {
                    D[p.v] =  D[cur] + p.weight;
                    pq.add(new Pair(p.v, D[p.v]));
                }
            }
        }

    }



}

