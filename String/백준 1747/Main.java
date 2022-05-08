import java.io.*;
import java.math.BigDecimal;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.max;


public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] arr = new boolean[1004000];
        Arrays.fill(arr, true);
        arr[1] = false;

        for (int i = 2; i * i < 1004000; i++) {
            if(arr[i]== false)continue;
            for (int j = i + i; j < 1004000; j += i) {
                arr[j] = false;
            }
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = N; i < 10040000 ; i++) {
            if(arr[i] == false) continue;
            if (F(i)) {
                System.out.println(i);
                break;
            }
        }

    }

    public static boolean F(int a) {
        sb.append(a);
        int lo = 0; int hi = sb.length()-1;
        while (lo <= hi) {
            if (sb.charAt(lo) != sb.charAt(hi)) {
                sb.setLength(0);
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
