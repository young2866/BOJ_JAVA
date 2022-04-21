import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static int[] arr;
    static public class Pair implements Comparable<Pair>{
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.a == o.a) {
                return o.b - this.b;
            }
            return this.a - o.a;
        }
    }

    static int[] dx = {1, 0,-1,0};
    static int[] dy = {0, 1,0,-1};

    static int N;
    static int M;
    static int T;
    static int MAX = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while (T-- > 0) {
            M = sc.nextInt();
            N = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            int count = x % (M + 1);
            int tempY = x;
            for (int j = 0; j < N; j++) {
                int ty = tempY % N == 0 ? N : tempY % N;
                if (ty == y) {
                    break;
                }
                tempY = ty + M;
                count += M;
            }
            System.out.println(count > LCM(M, N) ? -1 : count);
        }


    }

    public static int GCD(int a, int b) {
        if(a % b == 0) return b;
        return GCD(b, a % b);
    }

    public static int LCM(int a, int b) {
        return a * b / GCD(a, b);
    }


}

