import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Main {

    static int N;
    static long count = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        long arr[] = new long[1000001];
        long dp[] = new long[1000001];
        Arrays.fill(arr, 1);

        for (int i = 2; i < arr.length; i++) {
            for (int j = 1; j * i < arr.length; j++) {
                arr[i*j] += i;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i] += dp[i - 1] + arr[i];
        }

        while (N-- > 0) {
            int A = Integer.parseInt(br.readLine());

            sb.append(dp[A]).append('\n');
        }
        System.out.println(sb);
    }



}
