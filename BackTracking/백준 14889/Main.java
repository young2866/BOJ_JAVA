import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import static java.lang.Math.*;


public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] arr;
    static boolean[] chk;
    static int ans = 999999999;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N][N];
        chk = new boolean[N];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        func(0, 0);
        System.out.println(ans);
    }

    public static void func(int idx, int a) {
        if (idx == N / 2) {
            int lsum = 0; int ssum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(chk[i] && chk[j]) lsum += arr[i][j];
                    if(!chk[i] && !chk[j]) ssum += arr[i][j];
                }
            }
            int temp = abs(lsum - ssum);
            if(temp< ans) ans = temp;
            return;
        }
        for (int i = a; i < N; i++) {
            chk[i] = true;
            func(idx + 1, i + 1);
            chk[i] = false;
        }

    }


}
