import java.io.*;
import java.math.BigDecimal;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.max;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        StringTokenizer s = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s.nextToken());
        }

        int lo = 0;
        int hi = 0;
        int sum = arr[lo];
        int MIN = Integer.MAX_VALUE;
        while (lo <= hi) {
            if (sum < S) {
                if(hi + 1 >= N) break;
                else hi++;
                sum += arr[hi];
            } else {
                if (MIN > hi - lo + 1) {
                    MIN = hi - lo + 1;
                }
                sum -= arr[lo++];
            }

        }
        if(MIN == Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(MIN);
    }



}
