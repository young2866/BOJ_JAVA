import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import static java.lang.Math.*;


public class Main {

    static StringBuilder sb = new StringBuilder();



    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String s = sc.next(); int count = 0;
        int sum = 0;
        while (true) {
            if (s.length() == 1) {
                if ((s.charAt(0) - '0') % 3 == 0) {
                    System.out.println(count);
                    System.out.println("YES");
                    break;
                } else {
                    System.out.println(count);
                    System.out.println("NO");
                    break;
                }
            } else {
                count++;
                for (int i = 0; i < s.length(); i++) {
                    sum += s.charAt(i) - '0';
                }
                sb.append(sum);
                s = sb.toString();
                sb.setLength(0);
                sum = 0;
            }
        }



    }



}
