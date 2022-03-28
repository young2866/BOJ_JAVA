import java.util.*;

import static java.lang.Math.max;


public class Main {
    static class Pair {
        int x,y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] T;
    static int M, N;
    static int ans = 1;
    static boolean[][] visited;

    static int[] d_x = {0, 0, -1, 1};
    static int[] d_y = {1, -1, 0, 0};

    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        T = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                T[i][j] = sc.nextInt();
                if(T[i][j] == 1) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
                if(T[i][j] == -1)
                    visited[i][j] = true;
            }
        }

        bfs();

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++)
                if(T[i][j] == 0)
                    ans = -1000;
        }
        if(ans == -1000)
            System.out.println("-1");
        else
            System.out.println(ans-1);
    }

    public static void bfs() {

        while (!q.isEmpty()) {
            int curr[] = q.poll();
            int curr_X = curr[0];
            int curr_Y = curr[1];


            for (int i = 0; i < 4; i++) {
                int Next_X = curr_X + d_x[i];
                int Next_Y = curr_Y + d_y[i];
                if (Next_X >= 0 && Next_Y >= 0 && Next_X < N && Next_Y < M) {
                    if (T[Next_X][Next_Y] == 0 && !visited[Next_X][Next_Y]) {
                        q.add(new int[]{Next_X, Next_Y});
                        visited[Next_X][Next_Y] = true;
                        T[Next_X][Next_Y] = T[curr_X][curr_Y] + 1;
                        ans = max(T[Next_X][Next_Y], ans);
                    }
                }
            }
        }
    }

}
