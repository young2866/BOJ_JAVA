import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import static java.lang.Math.*;


public class Main {

    static StringBuilder sb = new StringBuilder();
    static String s = "";
    char[] arr = {'a', 'i', 'e', 'o', 'u'};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        s = sc.next();
        while (!s.equals("end")) {
            boolean mchk = false;
            boolean oachk = true;
            int cjn = 0;
            int cmn = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
                        || s.charAt(i) == 'u') {
                    cjn = 0;
                    cmn += 1;
                    if(!mchk)
                        mchk = true;
                    if (cmn == 3) {
                        oachk = false;
                        break;
                    }
                } else{
                    cjn += 1;
                    cmn = 0;
                    if (cjn == 3) {
                        oachk = false;
                        break;
                    }
                }
                if (i >= 1 && s.charAt(i) == s.charAt(i - 1)) {
                    if(s.charAt(i) == 'e' || s.charAt(i) == 'o') continue;
                    else oachk=false;
                }
            }
            if (mchk && oachk) {
                System.out.println("<" + s + "> is acceptable.");
            } else {
                System.out.println("<" + s + "> is not acceptable.");
            }
            s = sc.next();
        }
    }



}
