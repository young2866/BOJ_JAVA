import java.io.*;
import java.math.BigDecimal;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.max;


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String s = br.readLine();
            int lo = 0; int hi = s.length()-1; int num = 0;
            if (F(s)) {
                System.out.println("0");
            } else {
                while (lo <= hi) {
                    if (s.charAt(lo) != s.charAt(hi)) {
                        if (F(s.substring(lo + 1, hi + 1))) {
                            System.out.println("1");
                        } else if (F(s.substring(lo, hi))) {
                            System.out.println("1");
                        }else
                            System.out.println("2");
                        break;
                    }
                    lo++;
                    hi--;
                }
            }

        }
    }

    public static boolean F(String str) {
        int lo = 0; int hi = str.length()-1;
        while (lo <= hi) {
            if (str.charAt(lo) != str.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }


}
