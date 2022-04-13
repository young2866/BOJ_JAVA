import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    public static class Pair {
        int H;
        int idx;

        public Pair(int H, int idx) {
            this.H = H;
            this.idx = idx;
        }
    }
    public static int BFS(int x, int y) {
        int size = 0;

        pq.add(new Pair(x, y));
        visited[x][y] = true;

        while (!pq.isEmpty()) {
            size++;
            Pair p = pq.poll();

                for (int i = 0; i < 4; i++) {
                    int dx = d_x[i] + p.H;
                    int dy = d_y[i] + p.idx;
                    if (dx < 0 || dx >= N || dy < 0 || dy >= M) continue;
                    if (map[dx][dy] == 1 && !visited[dx][dy]) {
                        pq.add(new Pair(dx, dy));
                        visited[dx][dy] = true;
                    }
                }
            }
        return size;

    }

    static int[] d_x = {1, 0, -1, 0};
    static int[] d_y = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int M;
    static Queue<Pair> pq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());



        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0; int MAX = 0; int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0 || visited[i][j]) continue;
                MAX = BFS(i,j);
                count++;
                ans = max(MAX, ans);
            }
        }
        System.out.println(count +"\n"+ ans);
    }


}
