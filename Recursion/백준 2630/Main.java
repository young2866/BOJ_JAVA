import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static int[][] arr;
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
    static int W = 0;
    static int B = 0;
    static int MAX = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        solve(1, 1, N);
        System.out.println(W);
        System.out.println(B);





    }

    public static void solve(int a, int b, int s) {
        boolean chk = true;

        int first = arr[a][b];
        for (int i = a; i < a + s; i++) {
            for (int j = b; j < b + s; j++) {
                if (arr[i][j] != first) {
                    chk = false;
                    break;
                }
            }
        }

        if (chk) {
            if (first == 0) W++;
            else B++;
        } else {
            int mid = s / 2;
            solve(a, b, mid);
            solve(a + mid, b, mid);
            solve(a, b + mid, mid);
            solve(a + mid, b + mid, mid);
        }
    }


}

