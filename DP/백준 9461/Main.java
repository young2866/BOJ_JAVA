import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static long[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        dp = new long[102];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i = 6; i <= 100; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            System.out.println(dp[temp]);
        }


   }




}
