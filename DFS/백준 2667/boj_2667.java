import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class boj_2667 {
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int[][] Apart;
    static int n;
    static int Apart_Count = 0;
    static boolean[][] visited;
    static ArrayList<Integer> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        Apart = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < n; j++) {
                Apart[i][j] = input.charAt(j) - '0';
            }
        }

        result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Apart[i][j] == 1 && !visited[i][j]) {
                 Apart_Count = 1;
                 find(i,j);
                    result.add(Apart_Count);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(int c : result) System.out.println(c);
    }
    public static int find(int x, int y){
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int d_x = x + dx[i];
            int d_y = y + dy[i];

            if (d_x >= 0 && d_y >= 0 && d_x < n && d_y < n) {
                if (Apart[d_x][d_y] == 1 && !visited[d_x][d_y]) {
                    find(d_x,d_y);
                    Apart_Count++;
                }
            }
        }
        return Apart_Count;
    }
}
