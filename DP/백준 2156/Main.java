import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static int[][] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        arr = new int[N];
        dp = new int[N][2];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0][0] = 0;
        dp[0][1] = arr[0];

        if (N >= 2) {
            dp[1][0] = dp[0][1];
            dp[1][1] = dp[0][1] + arr[1];
        }

        for (int i = 2; i < N; i++) {
            dp[i][0] = max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = max(arr[i-1] + dp[i-2][0] + arr[i], arr[i] + dp[i-2][1]);
        }

        System.out.println(max(dp[N-1][0],dp[N-1][1]));

   }




}
