import java.util.*;

import static java.lang.Math.min;


public class Main {

    static int N;
    static int[][] dp;
    static LinkedList<Integer>[] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dp = new int[N + 1][2];
        tree = new LinkedList[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new LinkedList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            tree[u].add(v);
            tree[v].add(u);
        }
        dfs(1, -1);

        System.out.println(min(dp[1][0], dp[1][1]));

    }

    public static void dfs(int n, int p) {
        dp[n][0] = 0;
        dp[n][1] = 1;

        for (int next : tree[n]) {
            if (next != p) {
                dfs(next, n);
                dp[n][0] += dp[next][1];
                dp[n][1] += min(dp[next][0], dp[next][1]);
            }
        }
    }

}

