import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import static java.lang.Math.*;


public class Main {

    static StringBuilder sb = new StringBuilder();
    static Stack<Character> st = new Stack<>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int idx = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                while (!st.isEmpty()) {
                    sb.append(st.pop());
                }
                while (s.charAt(i) != '>') {
                    sb.append(s.charAt(i++));
                }
                sb.append(s.charAt(i));
            } else if (s.charAt(i) == (char) 32) {
                while (!st.isEmpty()) {
                    sb.append(st.pop());
                }
                sb.append(s.charAt(i));
            } else if (i == s.length() - 1) {
                st.push(s.charAt(i));
                while (!st.isEmpty()) {
                    sb.append(st.pop());
                }
            } else {
                st.push(s.charAt(i));
            }

        }
        System.out.println(sb);

    }



}
