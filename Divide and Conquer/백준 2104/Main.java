import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;


public class Main {

    static int N;
    static long[] A;

    public static long DC(int s, int e) {
        if (s > e) return -1;
        else if(s == e) return A[s] * A[s];
        else{
            int mid = (s+e) / 2;
            long result = max(DC(s, mid-1), DC(mid+1, e));

            long sum = A[mid];
            long Min = A[mid];

            int l = mid; int r = mid;

            while (r - l < e - s) {
                long lv = l > s ? A[l-1] : -1;
                long rv = r < e ? A[r+1] : -1;

                if (lv > rv) {
                    sum += lv;
                    Min = min(Min, lv);
                    l--;
                }
                else{
                    sum += rv;
                    Min = min(Min, rv);
                    r++;
                }
                result = max(result,sum * Min);
             }
            return result;
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        A = new long[N];

        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            A[i] = temp;
        }

        System.out.println(DC(0, N-1));
    }


}
