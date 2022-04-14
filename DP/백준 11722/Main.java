import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static int[] dp;
    static int[] arr;
    static public class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        arr = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = N - 1; i >= 0; i--) {
            DP(i);
        }
        int MAX = 0;
        for (int i = 0; i < N; i++) {
            MAX = max(dp[i], MAX);
        }
        System.out.println(MAX);

   }

    public static int DP(int x) {
        if (dp[x] == 0) {
            dp[x] = 1;
            for (int i = x - 1; i >= 0; i--) {
                if (arr[x] < arr[i]) {
                    dp[x] = max(DP(i) + 1, dp[x]);
                }
            }
        }
        return dp[x];
    }


}
