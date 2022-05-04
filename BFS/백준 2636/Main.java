import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import static java.lang.Math.*;


public class Main {

    static public class Pair {
        int x;
        int y;

        public Pair( int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    static boolean[][] chk;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    static int M;
    static int time = 0;
    static int ans = 0;
    static Queue<Pair> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];
        chk = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        while (DFS() != 0) {
            for(int i = 0; i < N; i++)
                Arrays.fill(chk[i], false);
        }

    }

    public static int DFS() {
        chk[0][0] = true;
        int count = 0;
        q.add(new Pair(0, 0));
        time++;
        while (!q.isEmpty()) {
            Pair temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(nx >= N || ny >= M || nx < 0 || ny <0 || chk[nx][ny]) continue;
                if (arr[nx][ny] == 0) {
                    q.add(new Pair(nx, ny));
                } else {
                    arr[nx][ny] = 0;
                    count++;
                }
                chk[nx][ny] = true;
            }
        }
        if (count == 0) {
            System.out.println(--time);
            System.out.println(ans);
            return 0;
        }
        ans = count;
        return 1;
    }
}
