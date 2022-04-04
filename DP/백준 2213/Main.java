import java.util.*;

import static java.lang.Math.min;


public class Main {

    static int N;
    static List<Integer>[] node;
    static int[] weight;
    static boolean[] chk;
    static int[][] dp;
    static List<Integer> res;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        weight = new int[N + 1];
        chk = new boolean[N + 1];
        dp = new int[N + 1][2];
        node = new ArrayList[N + 1];
        res = new ArrayList<>();

        for(int i = 0; i < N + 1; i++)
            node[i] = new ArrayList<>();

        for (int i = 1; i < N+1; i++) {
            weight[i] = sc.nextInt();
        }

        for (int i = 0; i < N - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            node[u].add(v);
            node[v].add(u);
        }

        DFS(1);

        if (dp[1][1] > dp[1][0]) {
            System.out.println(dp[1][1]);
            trace(1,1);
        } else {
            System.out.println(dp[1][0]);
            trace(1,0);
        }

        Collections.sort(res);
        for (int i : res) {
            System.out.print(i + " ");
        }

    }

    public static void DFS(int cur) {
        int child_num = node[cur].size();

        dp[cur][0] = 0;
        dp[cur][1] = weight[cur];

        if (child_num == 0) {
            return;
        }

        chk[cur] = true;

        for (int child : node[cur]) {
            if (!chk[child]) {
                DFS(child);

                dp[cur][0] += Math.max(dp[child][0], dp[child][1]);
                dp[cur][1] += dp[child][0];
            }
        }
        chk[cur] = false;
    }

    public static void trace(int cur, int a) {
        chk[cur] = true;
        if (a == 1) {
            res.add(cur);
            for (int i = 0; i < node[cur].size(); i++) {
                int next = node[cur].get(i);
                if (!chk[next])
                    trace(next, 0);
            }
        }
        else {
            for (int i = 0; i < node[cur].size(); i++) {
                int next = node[cur].get(i);
                if (!chk[next]) {
                    if (dp[next][1] > dp[next][0]) {
                        trace(next, 1);
                    } else {
                        trace(next, 0);
                    }
                }
            }
        }
        chk[cur] = false;
    }

}

