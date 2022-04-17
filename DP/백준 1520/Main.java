import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static int[][] dp;
    static int[][] arr;
    static public class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    static int M;
    static int N;

    static int[] dx = {1, 0,-1,0};
    static int[] dy = {0, 1,0,-1};


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        dp = new int[M + 1][N + 1];
        arr = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }
        System.out.println(DP(1,1));


   }

    public static int DP(int x, int y) {
        if( x  == M && y == N)
            return 1;
        if(dp[x][y] != -1)
            return dp[x][y];
        dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx > M || nx < 1 || ny > N || ny < 1) continue;
            if(arr[x][y] > arr[nx][ny])
                dp[x][y] += DP(nx, ny);
        }
        return dp[x][y];
    }

}
