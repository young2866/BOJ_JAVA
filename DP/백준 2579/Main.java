import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static int[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        arr = new int[301];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        dp = new int[301];
        dp[0] = arr[0];
        dp[1] = arr[1] + arr[0];
        dp[2] = max(dp[0] + arr[2], arr[1] + arr[2]);
        for (int i = 3; i < N; i++) {
            dp[i] = max(dp[i - 2] + arr[i], dp[i - 3] + arr[i] + arr[i - 1]);
        }

        System.out.println(dp[N-1]);
   }




}
