import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static long[][] dp;
    static int[][] arr;
    static public class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    static int K;
    static int N;

    static int[] dx = {1, 0,-1,0};
    static int[] dy = {0, 1,0,-1};


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        dp = new long[K + 1][N + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                for (int x = 0; x <= j; x++) {
                    dp[i][j] += dp[i - 1][j - x];
                    dp[i][j] %= 1000000000;
                }
            }
        }
        System.out.println(dp[K][N]);


   }



}
