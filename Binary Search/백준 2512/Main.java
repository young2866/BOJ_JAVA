import java.util.*;

import static java.lang.Math.max;


public class Main {

    static int N;
    static int M;
    static int MAX = 0;
    static int[] T;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        T = new int[N];

        for(int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
            MAX = max(MAX, T[i]);
        }

        M = sc.nextInt();

        int l = 0, h = 1000000001;

        while (l + 1 < h) {
            int mid = (l + h) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if(mid > T[i]) sum += T[i];
                else sum += mid;
            }

            if(M >= sum) l = mid;
            else h = mid;
        }
        if(l != 1000000000)
            System.out.println(l);
        else
            System.out.println(MAX);

    }


}
