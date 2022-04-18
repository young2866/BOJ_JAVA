import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static int[] dpd;
    static int[] dpi;
    static int[] arr;
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

        arr = new int[N + 1];
        dpi= new int[N + 1];
        dpd = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        int MAX = 0;
        for (int i = N; i >= 1; i--) {
            MAX = max(MAX, DPD(i) + DPI(i) - 1);
        }


        System.out.println(MAX);



    }

    public static int DPI(int x) {
        if (dpi[x] == 0) {
            dpi[x] = 1;
            for (int i = x + 1; i <= N; i++) {
                if (arr[x] > arr[i]) {
                    dpi[x] = max(dpi[x], 1 + DPI(i));
                }
            }
        }
        return dpi[x];
    }

    public static int DPD(int x) {
        if (dpd[x] == 0) {
            dpd[x] = 1;
            for (int i = x - 1; i >= 1; i--) {
                if (arr[x] > arr[i]) {
                    dpd[x] = max(dpd[x], DPD(i) + 1);
                }
            }
        }
        return dpd[x];
    }

}

