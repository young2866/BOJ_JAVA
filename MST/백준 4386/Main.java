import java.util.*;

import static java.lang.Math.*;


public class Main {

    public static class A implements Comparable<A> {
        int s; int e;
        double v;

        public A(int s, int e, double v) {
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
    static double[] x;
    static double[] y;

    static  int[] parent;
    static boolean[] visited;
    static double result;
    static PriorityQueue<A> pq = new PriorityQueue<>();
    static int INF = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        parent = new int[N + 1];
        x = new double[N + 1];
        y = new double[N + 1];

        int count = 0;
        for (int i = 1; i <= N; i++) {
            x[i] = sc.nextDouble();
            y[i] = sc.nextDouble();

            for (int j = 1; j <= i; j++) {
                pq.add(new A(i, j, sqrt(pow(x[i]-x[j], 2.0)+pow(y[i]- y[j], 2.0))));
                count++;
            }
        }

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        result = 0;
        for (int i = 1; i <= count; i++) {
            A temp = pq.poll();
            int s = temp.s;
            int e = temp.e;
            int a = find(s);
            int b = find(e);
            if(a == b) continue;

            union(s, e);
            result += temp.v;
        }
        System.out.printf("%.2f",result);
        System.out.println();

    }



}

