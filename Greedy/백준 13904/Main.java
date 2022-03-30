import java.util.*;


public class Main {

    static public class Pair implements Comparable<Pair>{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair p) {
            return Integer.compare(p.y, this.y);
        }
    }


    static int N;
    static int D;
    static int W;
    static int[] S;

    static int ans = 0;

    static PriorityQueue<Pair> pq = new PriorityQueue<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = new int[1001];

        Arrays.fill(S, 0);


        for (int i = 0; i < N; i++) {
            D = sc.nextInt();
            W = sc.nextInt();

            pq.add(new Pair(D,W));
        }

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            int temp_x = temp.x;
            int temp_y = temp.y;

            if (S[temp_x] == 0) {
                S[temp_x] = temp.y;
                ans += temp_y;
            }
            else
            {
                for (int i = temp_x - 1; i > 0; i--) {
                    if (S[i] == 0) {
                        S[i] = temp.y;
                        ans += temp.y;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }


}
