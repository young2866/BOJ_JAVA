import java.io.*;
import java.math.BigDecimal;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.max;


public class Main {

    static boolean chk = false;
    static String S;
    static String T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        S = br.readLine();
        T = br.readLine();
        if(S.length() > T.length()) System.out.println("0");
        else F(S, T);
        if(chk) System.out.println("1");
        else System.out.println("0");
    }

    public static void F(String Target, String str) {
        if (Target.length() == str.length()) {
            if (Target.equals(str)) chk = true;
            else return;
        } else {
            if (str.charAt(0) == 'B') {
                String temp = "";
                for(int i = str.length() - 1; i >= 1; i--)
                    temp += str.charAt(i);
                F(Target, temp);
            }
            if (str.charAt(str.length() - 1) == 'A') {
                String temp = "";
                for (int i = 0; i < str.length() - 1; i++) {
                    temp += str.charAt(i);
                }
                F(Target, temp);
            }
        }
    }


}
