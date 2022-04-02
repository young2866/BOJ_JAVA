import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;


public class Main {
    public static class THREE {
        int a, b, c;

        public THREE(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }


    static int N;
    static int K;
    static long temp;
    static long ans;
    static int[] B;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();


        long l = 1; long h = K;

        while (l + 1 < h) {
            long mid = (l + h) / 2;
            long cnt = 0;
            for (int i = 1; i <= N; i++) {
                cnt += min(mid/i, N);
            }
            if (cnt >= K) {
                h = mid;
            }
            else l = mid;
        }

        System.out.println(h);
    }


}

