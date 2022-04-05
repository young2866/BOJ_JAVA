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
    static int E;
    static boolean[] chk;
    static int[] D;
    static List<Pair>[] p;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    static int INF = Integer.MAX_VALUE;
    static int L1,L2;
    static int[] result = new int[2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        E = sc.nextInt();

        chk = new boolean[N + 1];
        D = new int[N + 1];
        p = new ArrayList[N + 1];
        Arrays.fill(D, INF);
        for (int i = 1; i <= N; i++) {
            p[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int temp1 = sc.nextInt();
            int temp2 = sc.nextInt();
            int temp3 = sc.nextInt();

            p[temp1].add(new Pair(temp2, temp3));
            p[temp2].add(new Pair(temp1, temp3));
        }
        L1 = sc.nextInt();
        L2 = sc.nextInt();

        ans(L1, L2);

    }

    public static int Dijkstra(int s, int e) {
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
        int temp = D[e];
        Arrays.fill(chk, false);
        Arrays.fill(D, INF);
        return temp;
    }

    public static int ans(int L1, int L2) {
        int route1 = Dijkstra(1, L1);
        if(route1 == INF){
            System.out.println("-1");
            return 0;
        }
        int route2 = Dijkstra(L1, L2);
        if(route2 == INF){
            System.out.println("-1");
            return 0;
        }
        int route3 = Dijkstra(L2, N);
        if(route3 == INF){
            System.out.println("-1");
            return 0;
        }
        int route4 = Dijkstra(1, L2);
        if(route4 == INF){
            System.out.println("-1");
            return 0;
        }
        int route5 = Dijkstra(L2, L1);
        if(route5 == INF){
            System.out.println("-1");
            return 0;
        }
        int route6 = Dijkstra(L1, N);
        if(route6 == INF){
            System.out.println("-1");
            return 0;
        }

        System.out.println(min(route1 + route2 + route3, route4 + route5 + route6));
        return 0;
    }



}

