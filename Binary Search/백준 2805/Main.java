import java.util.*;



public class Main {

    static int N;
    static int M;

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
            int mid = (l+h)/2;

            long sum = 0;
            for (int i = 0; i < N; i++) {
                if(T[i] > mid) sum += T[i] - mid;
            }
            if(sum >= M) l = mid;
            else h = mid;
        }

        System.out.println(l);

    }


}
