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

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    static int N;
    static int M;
    static int MAX = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
                if (arr[i][j] == 1) {
                    dp[i][j] = 1;
                    MAX = 1;
                }
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (arr[i - 1][j] == 1 && arr[i - 1][j - 1] == 1 && arr[i][j - 1] == 1 && arr[i][j] == 1) {
                    dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1]);
                    dp[i][j] = min(dp[i][j], dp[i][j-1]) + 1;
                }
                MAX = max(MAX, dp[i][j]);
            }
        }
        System.out.println(MAX * MAX);


    }



}

