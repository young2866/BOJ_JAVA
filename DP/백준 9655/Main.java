import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import static java.lang.Math.*;



public class Main {


    static StringBuilder sb = new StringBuilder();
    static int[][] dp;
    static int K;
    static int N;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dp = new int[N + 1][2];
        dp[1][1] = 1;
        dp[1][0] = 0;
        if(N >= 2) {
            dp[2][1] = 0;
            dp[2][0] = 1;
        }
        if(N >= 3) {
        dp[3][1] = 1;
        dp[3][0] = 0;
        }

        for (int i = 4; i <= N; i++) {
            if (dp[i - 1][0] == 1) {
                dp[i][1] = 1;
            }else if(dp[i-3][0] == 1) dp[i][1] = 1;
            else dp[i][1] = 0;
            if (dp[i - 1][1] == 0) {
                dp[i][0] = 0;
            }else if(dp[i-3][1] == 0) dp[i][1] = 0;
            else dp[i][0] = 1;
        }
        if (dp[N][1] == 1) {
            System.out.println("SK");
        }else System.out.println("CY");
    }




}
