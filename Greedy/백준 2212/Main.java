import java.util.*;


public class Main {

    static int N;
    static int K;

    static int ans = 0;
    
    static int[] G;
    static Integer[] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        K = sc.nextInt();

        G = new int[N];
        D = new Integer[N - 1];

        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            G[i] = temp;
        }

        Arrays.sort(G);

        for (int i = 0; i < N-1; i++) {
            D[i] = G[i+1] - G[i];
        }

        Arrays.sort(D, Collections.reverseOrder());

        for (int i = K - 1; i < N - 1; i++) {
            ans += D[i];
        }

        System.out.println(ans);



    }


}
