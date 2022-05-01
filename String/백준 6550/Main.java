import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import static java.lang.Math.*;


public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        String str;
        while ((str =br.readLine()) != null){
            st = new StringTokenizer(str);
            String s = st.nextToken();
            String s1 = st.nextToken();

            int idx = 0;
            for (int i = 0; i < s1.length(); i++) {
                if(s.charAt(idx) == s1.charAt(i)) idx++;
                if (idx == s.length()) {
                    break;
                }
            }
            if (idx == s.length()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }

    }



}
