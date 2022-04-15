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

    static int[] dx = {1, 0, 1};
    static int[] dy = {0, 1, 1};

    static Queue<Pair> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        dp[1][1] = arr[1][1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {

                for (int x = 0; x < 3; x++) {
                    int nx = i + dx[x];
                    int ny = j + dy[x];
                    if(nx <= 0 || nx > N ||ny <= 0 || ny > M ) continue;
                    dp[nx][ny] = max(dp[i][j] + arr[nx][ny], dp[nx][ny]);
                }
            }
        }

        System.out.println(dp[N][M]);
   }




}
