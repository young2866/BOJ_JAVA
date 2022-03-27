import java.util.*;

public class Main {
    static int N;
    static int M;
    static int V;

    static int[][] chk;
    static boolean[] visited;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        chk = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            chk[a][b] = 1;
            chk[b][a] = 1;
        }

        dfs(V);

        visited = new boolean[N + 1];
        System.out.println();

        bfs();
    }

    public static void dfs(int x) {
        visited[x] = true;
        System.out.print(x + " ");

        for (int i = 1; i <= N; i++) {
            if(chk[x][i] == 1 && !visited[i])
                dfs(i);
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(V);
        visited[V] = true;
        System.out.print(V + " ");

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int j = 1; j <= N; j++) {
                if (!visited[j] && chk[temp][j] == 1) {
                    queue.offer(j);
                    visited[j] = true;
                    System.out.print(j + " ");
                }
            }
        }
    }

}
