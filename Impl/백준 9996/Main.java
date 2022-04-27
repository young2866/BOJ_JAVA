import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        String s = sc.next();
        boolean chk = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                chk = false;
                continue;
            }
            if (chk) {
                first.append(s.charAt(i));
            } else {
                second.append(s.charAt(i));
            }
        }

        for (int i = 0; i < N; i++) {
            String s1 = sc.next();
            chk = true;
            if(s1.length() < first.length() + second.length())
                chk = false;
            for (int x = 0; x < first.length(); x++) {
                if (s1.charAt(x) != first.charAt(x)) {
                    chk = false;
                    break;
                }
            }
            int idx = s1.length() - 1;
            if (chk) {
                for (int x = second.length() - 1; x >= 0; x--) {
                    if (s1.charAt(idx--) != second.charAt(x)) {
                        chk = false;
                        break;
                    }
                }
            }
            if (chk) {
                sb.append("DA").append('\n');
            } else {
                sb.append("NE").append('\n');
            }
        }
        System.out.println(sb);



    }





}
