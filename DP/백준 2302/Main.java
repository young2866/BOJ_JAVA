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

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};


    static Queue<Pair> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[N];
        dp = new int[N + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int ans = 1; int idx = 1;
        for (int i = 0; i < M; i++) {
            int temp = sc.nextInt();
            ans *= dp[temp-idx];
            idx = temp + 1;
        }
        ans *= dp[N + 1 - idx];
        System.out.println(ans);




   }


}
