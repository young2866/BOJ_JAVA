import java.util.*;


public class Main {

    static int L;
    static int N;

    static int ans = 0;

    static PriorityQueue<Integer> W  = new PriorityQueue<>();



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();


        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            W.add(temp);
        }

        while (!W.isEmpty()) {
            int temp = W.poll();
            ans++;
            temp += (L - 1);
            for (; ; ) {
                if (!W.isEmpty()) {
                    if (temp < W.peek()) {
                        break;
                    } else
                        W.poll();
                }
                else
                    break;
            }
        }
        System.out.println(ans);

    }


}
