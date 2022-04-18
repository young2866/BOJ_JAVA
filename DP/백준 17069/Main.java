import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static long[][][] dp;
    static int[][] arr;
    static public class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static int[] dx = {1, 0,-1,0};
    static int[] dy = {0, 1,0,-1};

    static int N;
    static int M;
    static int MAX = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new int[N][N];
        dp = new long[N][N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dp[0][1][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if(arr[i][j] == 1) continue;
                dp[i][j][0] = dp[i][j-1][2] + dp[i][j-1][0];
                if(i == 0) continue;
                dp[i][j][1] = dp[i-1][j][2] + dp[i-1][j][1];
                if(arr[i-1][j] == 1 || arr[i][j-1] == 1) continue;
                dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
            }
        }
        long ans = 0;
        for (int i = 0; i < 3; i++) {
            ans += dp[N - 1][N - 1][i];
        }
        System.out.println(ans);
    }



}

