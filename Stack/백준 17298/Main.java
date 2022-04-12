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

        Stack<Pair> nums = new Stack<>();
        int[] NGE = new int[N ];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if (nums.isEmpty()) {
                nums.push(new Pair(temp, i));
            } else {
                if (nums.peek().H < temp) {
                    while (!nums.isEmpty()) {
                        NGE[nums.peek().idx] = temp;
                        nums.pop();
                        if (!nums.isEmpty() && nums.peek().H >= temp) {
                            break;
                        }
                    }
                    nums.push(new Pair(temp, i));
                } else {
                    nums.push(new Pair(temp, i));
                }
            }
        }
        while (!nums.isEmpty()) {
            NGE[nums.peek().idx] = -1;
            nums.pop();
        }
        for (int i : NGE) {
            bw.write(i + " ");
        }
        bw.flush();


    }



}

