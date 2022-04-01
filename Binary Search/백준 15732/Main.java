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
    static int D;
    static THREE[] T;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        D = sc.nextInt();

        T = new THREE[K];

        for (int i = 0; i < K; i++) {
            int temp1 = sc.nextInt();
            int temp2 = sc.nextInt();
            int temp3 = sc.nextInt();

            THREE temp = new THREE(temp1, temp2, temp3);
            T[i] = temp;
        }

        long l = 1; long h = N;

        while (l + 1 < h) {
            long mid = (l + h) / 2;
            long cnt = 0;
            for (int i = 0; i < K; i++) {
                if(T[i].b < mid)
                    cnt += (T[i].b - T[i].a) / T[i].c + 1;
                else if(T[i].a > mid) continue;
                else if(T[i].a == mid) cnt += 1;
                else cnt += (mid - T[i].a) / T[i].c +1;
            }
            if (cnt >= D) {
                h = mid;
            }
            else
                l = mid;
        }
        System.out.println(h);
    }


}

