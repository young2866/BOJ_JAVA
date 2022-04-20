import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static char[][] arr;
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

        arr = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], ' ');
        }
        solve(0, N - 1, N);

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }



    }

    public static void solve(int a, int b, int s) {
        if (s == 3) {
            arr[a][b] = '*';
            arr[a + 1][b - 1] = '*';
            arr[a + 1][b + 1] = '*';
            arr[a + 2][b - 2] = '*';
            arr[a + 2][b - 1] = '*';
            arr[a + 2][b] = '*';
            arr[a + 2][b + 1] = '*';
            arr[a + 2][b + 2] = '*';
            return;

        } else {
            int nsize = s / 2;
            solve(a, b, nsize);
            solve(a + nsize, b - nsize, nsize);
            solve(a + nsize, b + nsize, nsize);
        }
    }


}

