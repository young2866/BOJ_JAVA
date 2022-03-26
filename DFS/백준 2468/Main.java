import java.util.*;

import static java.lang.Math.max;

public class Main {

    static int N;
    static int[][] Map;
    static boolean[][] visited;
    static int[] d_x = {0, 0, -1, 1};
    static int[] d_y = {1, -1, 0, 0};
    static int count = 0;
    static int Max = 0;
    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        Map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Map[i][j] = sc.nextInt();
                Max = max(Max, Map[i][j]); // MAX높이 저장용
            }
        }

        for(int x = 0; x < Max; x++) { // <=이 아닌 이유 -> MAX까지 잠기면 어차피 0임.
            for (int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++)
                    visited[i][j] = false;
            }// 높이가 변할 때마다, 방문 배열을 초기화 해줘야함.
            count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (Map[i][j] - x > 0 && !visited[i][j]) {
                        count++;
                        dfs(x,i,j);
                    }
                }
            }
            res = max(res, count);
        }
        System.out.println(res);
    }

    public static void dfs(int H, int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int dx = x + d_x[i];
            int dy = y + d_y[i];
            if (dx >= 0 && dy >= 0 && dx < N && dy < N) {
                if(Map[dx][dy] - H > 0 && !visited[dx][dy])
                    dfs(H, dx, dy);
            }
        }
    }
}
