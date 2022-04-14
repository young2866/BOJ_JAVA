import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static int[][] dp;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dp = new int[N][N];
        dp[0][0] = arr[0][0];
        if(N >= 2) {
            dp[1][0] = arr[0][0] + arr[1][0];
            dp[1][1] = arr[0][0] + arr[1][1];
        }
        for (int i = 2; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j - 1 < 0) {
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                } else if (j > i - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
                } else {
                    dp[i][j] = max(dp[i - 1][j] + arr[i][j], dp[i - 1][j - 1] + arr[i][j]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = max(dp[N - 1][i], ans);
        }
        System.out.println(ans);



   }




}
