import java.io.*;
import java.math.BigDecimal;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.max;


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> st = new Stack<>();
        String s = " ";
        int idx = 1;
        while (s.charAt(0) != '-') {
            s = br.readLine();
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '{') st.push(s.charAt(i));
                if (s.charAt(i) == '}') {
                    if(!st.isEmpty() && st.peek() == '{') st.pop();
                    else st.push(s.charAt(i));
                }
            }
            int count = 0;
            while (!st.isEmpty()) {
                char a = st.pop();
                if (a == '{') {
                    count++;
                    if (st.peek() == '{') {
                        st.pop();
                    } else {
                        st.pop();
                        count++;
                    }
                } else {
                    if (st.peek() == '{') {
                        st.pop();
                    } else {
                        count++;
                        st.pop();
                    }
                }
            }
            if(s.charAt(0) != '-')
            System.out.println(idx + ". " + count);
            idx++;

            st.clear();
        }
    }



}
