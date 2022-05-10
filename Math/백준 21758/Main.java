import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static long[] Rsum;
    static long[] Lsum;
    static long def = 0;
    static long ans = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        Rsum = new long[N];
        Lsum = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long temp = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            temp += arr[i];
            Rsum[i] = temp;
        }
        temp = 0;
        for (int i = N - 1; i >= 0; i--) {
            temp += arr[i];
            Lsum[i] = temp;
        }

        def = Rsum[N - 1];
        F();
        System.out.println(ans);


    }

    public static void F() {
        for (int i = 1; i <= N - 2; i++) {
            long first = def - arr[i] - arr[0];
            long second = def - Rsum[i];
            ans = Math.max(ans, first + second);
        }
        for (int i = N - 2; i >= 1; i--) {
            long first = def - arr[N - 1] - arr[i];
            long second = def - Lsum[i];
            ans = Math.max(ans, first + second);
        }
        for (int i = 1; i <= N - 2; i++) {
            long first = Rsum[i] - arr[0];
            long second = Lsum[i] - arr[N - 1];
            ans = Math.max(ans, first + second);
        }
    }


}
