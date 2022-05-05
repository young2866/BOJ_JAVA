import java.io.*;
import java.util.*;

import static java.lang.Math.abs;


public class Main {
    static int N;
    static int M;
    static int[] time;
    static long MIN = Long.MAX_VALUE;
    static long MAX = 0;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        time = new int[N];
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(br.readLine());
            MAX = Math.max(MAX, time[i]);
        }
        go(N, M);
        System.out.println(MIN);

    }

    public static void go(int n, int m) {
        long lo = 0;
        long hi = MAX * m;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            long sum = 0;

            for (int i : time) {
                long count = mid / i;
                if (sum >= m) {
                    break;
                }
                sum += count;
            }
            if (sum >= m) {
                MIN = Math.min(MIN, mid);
                hi = mid - 1;
            }else lo = mid + 1;
        }
    }

}
