import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int N;
    static char[][] Picture;
    static boolean[][] N_visited;
    static boolean[][] visited;
    static int[] d_x = {0, 0, -1, 1};
    static int[] d_y = {1, -1, 0, 0};
    static int N_count = 0;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        Picture = new char[N][N];
        N_visited = new boolean[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                Picture[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!N_visited[i][j]) {
                    N_dfs(i, j);
                    N_count++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
//                    System.out.println(i + " " + j);
                    count++;
                }
            }
        }
        System.out.println(N_count + " " + count);
    }

    public static void N_dfs(int x, int y) {
        N_visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int dx = x + d_x[i];
            int dy = y + d_y[i];
            if (dx >= 0 && dy >= 0 && dx < N && dy < N) {
                if(Picture[dx][dy] == Picture[x][y] && !N_visited[dx][dy]) N_dfs(dx, dy);
            }
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int dx = x + d_x[i];
            int dy = y + d_y[i];
            if (dx >= 0 && dy >= 0 && dx < N && dy < N) {
                if (!visited[dx][dy]) {
                    if((Picture[dx][dy] == 'R' || Picture[dx][dy] == 'G') && (Picture[x][y] == 'R' || Picture[x][y] == 'G'))
                        dfs(dx, dy);
                    else if(Picture[dx][dy] == Picture[x][y])
                        dfs(dx, dy);
                }
            }
        }
    }
}
