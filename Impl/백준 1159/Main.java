import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[26];
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            int temp = s.charAt(0) - 'a';
            arr[temp]++;
        }
        boolean chk = true;
        for (int i = 0; i < 26; i++) {
            if (arr[i] >= 5) {
                char a = (char) (i + 97);
                sb.append(a);
                chk = false;
            }
        }
        if (!chk) {
            System.out.println(sb);
        } else {
            System.out.println("PREDAJA");
        }



    }





}
