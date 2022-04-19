import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static int[] arr;
    static public class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static int[] dx = {1, 0,-1,0};
    static int[] dy = {0, 1,0,-1};

    static int N;
    static int M;
    static int MAX = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> st = new Stack<>();
        boolean chk = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                if (st.size() < 2 || i + 1 == s.length() || s.charAt(i + 1) != 'P') {
                    chk = false;
                    break;
                } else {
                    st.pop();
                    st.pop();
                }
            } else {
                st.push(s.charAt(i));
            }
        }
        if (st.size() == 1 && st.peek() == 'P' && chk) {
            System.out.println("PPAP");
        }else
            System.out.println("NP");

    }



}

