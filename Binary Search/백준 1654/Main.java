import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;


public class Main {

    static int K;
    static int N;
    static int MIN = 100000;
    static int count = 0;
    static int[] T;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        N = sc.nextInt();

        T = new int[K];

        for (int i = 0; i < K; i++) {
            T[i] = sc.nextInt();
        }

        long l = 0;
        long h = Long.MAX_VALUE;

        while (l + 1 < h) {
            long mid = (l + h)/2;
            long sum = 0;
            for (int i = 0; i < K; i++) {
                if (T[i] >= mid) {
                    sum += (T[i] / mid);
                }
            }
            if(sum >= N)
                l = mid;
            else
                h = mid;
        }
        System.out.println(l);

    }


}
