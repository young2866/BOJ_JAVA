import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import static java.lang.Math.*;


public class Main {

    static public class Pair {
        int a;
        int b;
        int des;

        public Pair(int a, int b, int des) {
            this.a = a;
            this.b = b;
            this.des = des;
        }
    }


    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    static int[][] dist;
    static boolean[][][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    static int M;
    static Queue<Pair> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];
        visit = new boolean[2][N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        if (N-1 == 0 && M-1 == 0) {
            System.out.println("1");
            System.exit(0);
        }

        q.offer(new Pair(0, 0, 0));
        while (!q.isEmpty()) {
            Pair temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp.a + dx[i];
                int ny = temp.b + dy[i];

                if(nx >= N || nx <0 || ny >= M || ny < 0 )continue;

                if (arr[nx][ny] == 1) {
                    if (temp.des == 0 && !visit[1][nx][ny]) {
                        q.add(new Pair(nx, ny, 1));
                        visit[temp.des][nx][ny] = true;
                        dist[nx][ny] = dist[temp.a][temp.b] + 1;
                    }
                } else {
                    if (!visit[temp.des][nx][ny]) {
                        visit[temp.des][nx][ny] = true;
                        dist[nx][ny] = dist[temp.a][temp.b] + 1;
                        q.add(new Pair(nx, ny, temp.des));
                    }
                }
                if(nx == N-1 && ny == M-1) {
                    System.out.println(dist[nx][ny] + 1);
                    System.exit(0);
                }
            }
        }
        System.out.println("-1");

    }




}
