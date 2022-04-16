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
    static int N;
    static int K;

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};


    static Queue<Pair> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        dp = new int[K + 1];
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            if(arr[i] > K)continue;
            dp[arr[i]]++;
            for (int j = arr[i]; j <= K; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }
        System.out.println(dp[K]);
   }



}
