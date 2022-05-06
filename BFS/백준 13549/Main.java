import java.io.*;
import java.math.BigDecimal;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.max;


public class Main {

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int X;
    static int MAX = 100000;
    static int MIN = Integer.MAX_VALUE;
    static boolean[] chk = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        F();
        System.out.println(MIN);

    }
    public static void F() {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(N, 0));

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            chk[temp.x] = true;
            if(temp.x == X) MIN = Math.min(temp.y, MIN);

            if(temp.x * 2 <= MAX && !chk[temp.x*2]) q.add(new Pair(temp.x * 2, temp.y));
            if(temp.x + 1 <= MAX && !chk[temp.x + 1]) q.add(new Pair(temp.x + 1, temp.y + 1));
            if(temp.x - 1 >= 0 && !chk[temp.x - 1]) q.add(new Pair(temp.x - 1, temp.y + 1));
        }
    }


}
