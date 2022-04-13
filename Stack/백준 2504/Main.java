import java.io.*;
import java.util.*;

import static java.lang.Math.*;


public class Main {
    public static class Pair {
        int H;
        int idx;

        public Pair(int H, int idx) {
            this.H = H;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        Stack<Character> st = new Stack<>();
        String s = br.readLine();

        int idx = 1;
        int ans = 0;
        boolean chk = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
                idx *= 2;
            } else if (s.charAt(i) == '[') {
                st.push(s.charAt(i));
                idx *= 3;
            } else if (s.charAt(i) == ')') {
                if (st.isEmpty() || st.peek() != '(') {
                    ans = 0;
                    chk = true;
                } else {
                    if (s.charAt(i - 1) == '(') ans += idx;
                    st.pop();
                    idx /= 2;
                }
            } else if (s.charAt(i) == ']') {
                if (st.isEmpty() || st.peek() != '[') {
                    ans = 0;
                    chk = true;
                } else {
                    if (s.charAt(i - 1) == '[') ans += idx;
                    st.pop();
                    idx /= 3;
                }
            }


        }
        System.out.println(!st.isEmpty() || chk ? 0 : ans);


    }
}
