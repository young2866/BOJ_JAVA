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
    static int M;
    static int N;
    static int K;
    static long mul;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        Pair T = null;
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        boolean chk = true;
        if (K == 0) {
            chk = false;
        }

        arr = new int[N][M];
        dp = new long[N][M];
        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = i * M + (j + 1);
                if(arr[i][j] == K)
                    T = new Pair(i, j);
            }
        }
        if(chk) {
            for (int i = 0; i <= T.x; i++) {
                for (int j = 0; j <= T.y; j++) {
                    for (int x = 0; x < 2; x++) {
                        int nx = i + dx[x];
                        int ny = j + dy[x];
                        if (nx > T.x || ny > T.y) continue;
                        dp[nx][ny] += dp[i][j];
                    }
                }
            }
            mul = chk ? dp[T.x][T.y] : 1;
            dp[T.x][T.y] = 1;
        }

        for (int i = chk?T.x : 0; i < N; i++) {
            for (int j = chk?T.y : 0; j < M; j++) {
                for (int x = 0; x < 2; x++) {
                    int nx = i + dx[x];
                    int ny = j + dy[x];
                    if(nx > N-1 || ny > M-1) continue;
                    dp[nx][ny] += dp[i][j];
                }
            }
        }
        long ans = chk ? dp[N - 1][M - 1] * mul : dp[N - 1][M - 1];
        System.out.println(ans);


   }



}
