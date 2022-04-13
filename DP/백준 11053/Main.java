import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static int[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int A = Integer.parseInt(br.readLine());

        arr = new int[A];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[A];

        for (int i = 0; i < A; i++) {
            DP(i);
        }

        int ans = -1;

        for (int i = 0; i < A; i++) {
            ans = max(dp[i], ans);
        }
        System.out.println(ans);

   }

    static int DP(int N) {
        if(dp[N] == 0) {
            dp[N] = 1;
            for (int i = N - 1; i >= 0; i--) {
                if (arr[N] > arr[i]) {
                    dp[N] = max(DP(i) + 1, dp[N]);
                }
            }
        }
        return dp[N];
    }


}
