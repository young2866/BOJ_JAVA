import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static int[] dp;
    static public class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    static int N;
    static int K;

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};


    static Queue<Pair> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        dp = new int[31];

        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;
        dp[3] = 0;
        dp[4] = 11;

        for (int i = 5; i <= N; i++) {
            if (i % 2 == 1) {
                dp[i] = 0;
            } else {
                dp[i] += (dp[i - 2] * dp[2]);
                for (int j = i-4; j >= 0; j -= 2) {
                    dp[i] += dp[j] * 2;
                }
            }
        }

        System.out.println(dp[N]);

   }



}
