import java.io.*;
import java.util.*;

import static java.lang.Math.abs;


public class Main {
    static int N;
    static int ans = 0;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            pq.add(a);
        }

        if (N == 1) {
            System.out.println("0");
        } else if (N == 2) {
            int a = pq.poll();
            System.out.println(a + pq.poll());
        } else {
            while (pq.size() >= 2) {
                int sum = pq.poll() + pq.poll();
                ans += sum;
                pq.add(sum);
            }
            System.out.println(ans);
        }

    }

}
