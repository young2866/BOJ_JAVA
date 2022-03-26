import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int M;
    static int N;
    static int K;

    static int[] d_x = {0, 0, -1, 1};
    static int[] d_y = {1, -1, 0, 0};

    static int[][] Map;

    static int count = 0;
    static ArrayList<Integer> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();

        Map = new int[M][N];

        for (int i = 0; i < K; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for(int a = y1; a < y2; a++)
                for(int b = x1; b < x2; b++)
                    Map[a][b] = 1;
        }

        result = new ArrayList<Integer>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (Map[i][j] == 0) {
                    count = 0;
                    DFS(i, j);
                    result.add(count);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(int c : result) System.out.print(c + " ");
    }

    public static void DFS(int x, int y) {
        Map[x][y] = 1;
        count++;

        for (int i = 0; i < 4; i++) {
            int dx = x + d_x[i];
            int dy = y + d_y[i];

            if(dx >= 0 && dy >= 0 && dx < M && dy < N)
                if(Map[dx][dy] == 0) DFS(dx, dy);
        }
    }
}
