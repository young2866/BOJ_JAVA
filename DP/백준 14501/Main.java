import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static int[] dp;
    static Pair[] arr;
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

        arr = new Pair[N+1];
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[i] = new Pair(a, b);
        }

        for (int i = N; i > 0; i--) {
            if (i + arr[i].x - 1 > N) {
                dp[i] = 0;
                continue;
            } else {
                if (i + arr[i].x - 1 == N) {
                    dp[i] = arr[i].y;
                } else {
                    for (int j = i + arr[i].x; j <= N; j++) {
                        dp[i] = max(dp[i], arr[i].y + dp[j]);
                    }
                }

            }
        }
        int MAX = 0;
        for (int i = 1; i <= N; i++) {
            MAX = max(dp[i], MAX);
        }
        System.out.println(MAX);

   }




}
