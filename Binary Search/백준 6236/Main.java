import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;


public class Main {

    static int N;
    static int M;
    static int MIN = 100000;
    static int count = 0;
    static int[] T;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        T = new int[N];
        for (int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
        }

        int l = 0, h = 1000000001;

        while (l + 1 < h) {
            int mid = (l + h) / 2;
            int chk = 1;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (T[i] > mid) {
                    chk = 0;
                    break;
                } else if (sum + T[i] > mid) {
                    count++;
                    sum = T[i];
                } else {
                    sum += T[i];
                }
            }
            if (chk != 0 && M > count) {
                h = mid;
            }
            else l = mid;

            count = 0;
        }

        System.out.println(h);
    }


}
