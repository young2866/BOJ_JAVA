import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static int[][][] dp;
    static int[][] arr;
    static public class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    static int N;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new int[N + 1][4];
        int[][] maxdp = new int[N + 1][4];
        int[][] mindp = new int[N + 1][4];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int MIN = 9000001; int MAX = -1;
        for(int i = 1; i <= N; i++){
            maxdp[i][1] = max(maxdp[i - 1][1], maxdp[i - 1][2]) + arr[i][1];
            maxdp[i][2] = max(maxdp[i - 1][1], max(maxdp[i - 1][2], maxdp[i - 1][3])) + arr[i][2];
            maxdp[i][3] = max(maxdp[i - 1][2], maxdp[i - 1][3]) + arr[i][3];

            mindp[i][1] = min(mindp[i - 1][1], mindp[i - 1][2]) + arr[i][1];
            mindp[i][2] = min(mindp[i - 1][1], min(mindp[i - 1][2], mindp[i - 1][3])) + arr[i][2];
            mindp[i][3] = min(mindp[i - 1][2], mindp[i - 1][3]) + arr[i][3];
        }

        for (int i = 1; i <= 3; i++) {
            MIN = min(MIN, mindp[N][i]);
            MAX = max(MAX, maxdp[N][i]);
        }
        System.out.println(MAX);
        System.out.println(MIN);






    }


}

