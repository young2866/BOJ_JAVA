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

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};


    static Queue<Pair> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        dp = new long[N][N];
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int x = 0; x < 2; x++) {
                    int nx = i + dx[x] * arr[i][j];
                    int ny = j + dy[x] * arr[i][j];

                    if(nx <= -1 || nx >= N || ny <= -1 || ny >= N || arr[i][j] == 0) continue;
                    dp[nx][ny]+= dp[i][j];
                }
            }
        }
        System.out.println(dp[N-1][N-1]);
   }




}
