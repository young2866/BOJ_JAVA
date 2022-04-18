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

    static int[] dx = {1, 0,-1,0};
    static int[] dy = {0, 1,0,-1};

    static int N;
    static int M;
    static int MAX = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        int MAX = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                MAX = max(MAX,DP(i, j));
            }
        System.out.println(MAX);

    }

    public static int DP(int x, int y) {
        if (dp[x][y] == 0) {
            dp[x][y] = 1;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1) continue;
                if (arr[nx][ny] > arr[x][y]) {
                    dp[x][y] = max(dp[x][y],DP(nx, ny) + 1);
                }
            }
        }
        return dp[x][y];
    }


}

