import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static int[] arr;
    static boolean[] chk;

    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        chk = new boolean[N + 1];
        arr = new int[N + 1];

        Back(0);
        System.out.println(sb);
    }

    public static void Back(int idx) {
        if (idx == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(chk[i]) continue;
            chk[i] = true;
            arr[idx] = i;
            Back(idx + 1);
            chk[i] = false;
        }
    }





}