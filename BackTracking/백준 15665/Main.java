import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static int[] arr;
    static int[] num;
    static boolean[] chk;

    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        num = new int[N];
        arr = new int[M];

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);

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
        int before = -1;
        for (int i = 0; i < N; i++) {
            int now = num[i];
            if(before == now) continue;
            arr[idx] = now;
            before = now;
            Back(idx + 1);
        }

    }





}