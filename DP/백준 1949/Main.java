import java.util.*;

import static java.lang.Math.min;


public class Main {

    static int N;
    static List<Integer>[] node;
    static int[] pop;
    static boolean[] chk;
    static int[][] dp;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        node = new ArrayList[N + 1];
        pop = new int[N + 1];
        chk = new boolean[N + 1];
        dp = new int[N + 1][2];

        for (int i = 0; i < N + 1; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            pop[i] = sc.nextInt();
        }
        for (int i = 1; i < N; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            node[u].add(v);
            node[v].add(u);
        }
        DFS(1);

        System.out.println(Math.max(dp[1][0],dp[1][1]));

    }

    public static void DFS(int cur) {
        int temp = node[cur].size();
        if (temp == 0) {
            return;
        }

        dp[cur][0] = 0;
        dp[cur][1] = pop[cur];

        chk[cur] = true;

        for (int next : node[cur]) {
            if (!chk[next]) {
                DFS(next);

                dp[cur][0] += Math.max(dp[next][1], dp[next][0]);
                dp[cur][1] += dp[next][0];
            }
        }
    }



}

