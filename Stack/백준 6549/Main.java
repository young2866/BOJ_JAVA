import java.io.*;
import java.util.*;

import static java.lang.Math.*;


public class Main {
    public static class Pair {
        int H; int idx;

        public Pair(int H, int idx) {
            this.H = H;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = 1;
        while (true) {
            long ans = 0;
            Stack<Integer> histo = new Stack<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {

                while (!histo.isEmpty() && arr[histo.peek()] > arr[i]) {
                    int H = arr[histo.pop()];
                    long W = histo.isEmpty() ? i : i -1 -histo.peek();

                    ans = Math.max(H * W, ans);
                }
                histo.push(i);
            }

            while (!histo.isEmpty()) {
                int H = arr[histo.pop()];
                long W = histo.isEmpty() ? N : N -1 - histo.peek();

                ans = Math.max(H * W, ans);
            }

            System.out.println(ans);
        }



    }



}

