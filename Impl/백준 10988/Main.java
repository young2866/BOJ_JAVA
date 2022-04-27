import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int idx = s.length()-1;
        boolean chk = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(idx) != s.charAt(i)) {
                chk = false;
                break;
            }
            idx--;
        }
        if (chk) {
            System.out.println("1");
        }else System.out.println("0");

    }





}
