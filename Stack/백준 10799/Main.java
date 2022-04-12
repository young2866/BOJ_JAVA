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

            Stack<Integer> stack = new Stack<>();
            String s = br.readLine();

            int idx = 1; int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(idx);
            } else {
                if (idx - stack.peek() == 1) {
                    stack.pop();
                    ans += stack.size();
                } else {
                    stack.pop();
                    ans++;
                }

            }
            idx++;
        }

        System.out.println(ans);




    }



}

