import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import static java.lang.Math.*;


public class Main {

    static StringBuilder sb = new StringBuilder();


    static String s;
    static boolean[] chk;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        s= sc.next();
        chk = new boolean[s.length()];
        func(0, "");
        Collections.sort(arr);
        if (arr.isEmpty()) {
            System.out.println("0");
        }else System.out.println(arr.get(0));

    }

    public static void func(int idx, String str) {
        if (idx == s.length()) {
            int temp = Integer.parseInt(str);
            int target = Integer.parseInt(s);
            if (temp > target) {
                arr.add(temp);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if(chk[i]) continue;
            chk[i] = true;
            func(idx + 1, str + s.charAt(i));
            chk[i] = false;
        }
    }



}
