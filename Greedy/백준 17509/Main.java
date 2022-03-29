import java.util.*;


public class Main {

    static int L;
    static int N;

    static int ans = 0;
    static int time = 0;

    static PriorityQueue<Integer> W  = new PriorityQueue<>();



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 11; i++) {
            int Temp = sc.nextInt();
            int V = sc.nextInt();

            W.add(Temp);
            ans += (V * 20);
        }

        while (!W.isEmpty()) {
            time = time + W.poll();
            ans += time;
        }

        System.out.println(ans);

    }


}
