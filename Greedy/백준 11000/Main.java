import java.util.*;


public class Main {

    public static class Pair implements Comparable<Pair>{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair p) {
            if(this.x == p.x)
                return Integer.compare(this.y, p.y);
            else
                return Integer.compare(this.x, p.x);
        }
    }





    static int L;
    static int N;

    static int ans = 0;
    static int time = 0;


    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    static PriorityQueue<Integer> p = new PriorityQueue<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int tempx = sc.nextInt();
            int tempy = sc.nextInt();
            pq.add(new Pair(tempx, tempy));

        }

        Pair temp = pq.poll();
        int tempx = temp.x;
        int tempy = temp.y;
        p.add(temp.y);

        while(!pq.isEmpty()) {
            temp = pq.poll();
            tempx = temp.x;
            tempy = temp.y;

            if(p.peek() <= tempx)
                p.poll();

            p.add(tempy);


        }

        System.out.println(p.size());

    }


}
