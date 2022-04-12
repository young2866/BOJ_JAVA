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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[4000001];
        int head = 2000000;
        int tail = 2000000;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String s = st.nextToken();

            if (s.equals("push")) {
                int temp = Integer.parseInt(st.nextToken());
                arr[tail++] = temp;

            } else if (s.equals("front")) {
                if (head == tail) {
                        bw.write("-1\n");
                    } else {
                        bw.write(arr[head] + "\n");
                    }
            } else if (s.equals("back")) {
                if (head == tail) {
                        bw.write("-1\n");
                    } else {
                        bw.write(arr[tail-1] + "\n");
                    }
            } else if (s.equals("pop")) {
                if (head != tail) {
                        bw.write(arr[head] + "\n");
                        arr[head++] = 0;
                    } else {
                        bw.write("-1\n");
                    }
            } else if (s.equals("empty")) {
                if (head == tail) {
                        bw.write("1\n");
                    }else
                        bw.write("0\n");

            } else{
                bw.write(tail - head + "\n");
            }
        }
        bw.flush();




    }



}

