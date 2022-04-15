import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static long[] dp;
    static int[] arr;
    static public class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};


    static Queue<Pair> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        arr = new int[N];
        dp = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = N - 1; i >= 0; i--) {
            DP(i);
        }

        long MAX = 0;
        for (int i = 0; i < N; i++) {
            MAX = max(MAX, dp[i]);
        }
        System.out.println(MAX);


   }

    public static long DP(int x) {
        if (dp[x] == 0) {
            dp[x] = 1;
            for (int i = x - 1; i >= 0; i--) {
                if (arr[x] > arr[i]) {
                    dp[x] = max(dp[x], DP(i) + 1);
                }
            }
        }
        return dp[x];
    }


}
