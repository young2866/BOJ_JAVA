import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.min;


public class Main {

    public static class A implements Comparable<A> {
        int s; int e;
        int v;

        public A(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(A o) {
            return o.v >= this.v ? -1 : 1;
        }
    }

    public static int find(int a) {
        if(a == parent[a]) return a;
        parent[a] = find(parent[a]);
        return parent[a];
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot != bRoot) {
            parent[aRoot] = b;
        } else {
            return;
        }



    }


    static int N;
    static int M;

    static  int[] parent;
    static boolean[] visited;
    static long result;
    static PriorityQueue<A> pq = new PriorityQueue<>();
    static int INF = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        while (M + N != 0) {
            parent = new int[M];
            visited = new boolean[M];

            long All = 0;
            for (int i = 0; i < N; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();

                pq.add(new A(a, b, c));
                All += c;
            }

            for (int i = 0; i < M; i++) {
                parent[i] = i;
            }

            result = 0;
            for (int i = 0; i < N; i++) {
                A temp = pq.poll();
                int s = temp.s;
                int e = temp.e;
                int a = find(s);
                int b = find(e);
                if (a == b) continue;

                union(s, e);
                result += temp.v;
            }
            System.out.println(All - result);
            M = sc.nextInt();
            N = sc.nextInt();
        }

    }



}

