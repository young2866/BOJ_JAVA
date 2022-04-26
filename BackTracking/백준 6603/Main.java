import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static int K;
    static int[] num;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            K = sc.nextInt();
            if(K == 0) break;
            num = new int[K];
            arr = new int[6];
            for (int i = 0; i < K; i++) {
                num[i] = sc.nextInt();
            }
            back(0,0);
            System.out.println(sb);
            sb.setLength(0);
        }
    }

    public static void back(int a, int idx) {
        if (idx == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = a; i < K; i++) {
            arr[idx] = num[i];
            back(i + 1, idx + 1);
        }

    }


}
