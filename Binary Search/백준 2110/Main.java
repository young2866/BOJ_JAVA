import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;


public class Main {

    static int C;
    static int N;
    static int MIN = 100000;
    static int count = 0;
    static int[] T;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        C = sc.nextInt();

        T = new int[N];

        for (int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
        }

        Arrays.sort(T);

        int l = 0; int h = 1000000001;

        while (l + 1 < h) {
            int mid = (l + h) / 2;
            int temp = 0;
            count = 1;
            for (int i = 1; i < N; i++) {
                if (T[i] - T[temp] >= mid) {
                    temp = i;
                    count++;
                }
            }
            if (count >= C) {
                l = mid;
            }
            else
                h = mid;
        }

        System.out.println(l);
    }


}
