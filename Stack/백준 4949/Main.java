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

        while (true) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            boolean chk = false;
            if (s.equals(".")) {
                break;
            } else {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '(' || s.charAt(i) == '[') {
                        stack.push(s.charAt(i));
                    } else if (s.charAt(i) == ')') {
                        if (!stack.isEmpty() && stack.peek() == '(') {
                            stack.pop();
                        }else
                            chk = true;
                    } else if (s.charAt(i) == ']') {
                        if (!stack.isEmpty() && stack.peek() == '[') {
                            stack.pop();
                        } else {
                            chk = true;
                        }
                    }
                }
            }
            if (chk || stack.size() != 0) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }




    }



}

