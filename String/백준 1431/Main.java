import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import static java.lang.Math.*;


public class Main {

    static StringBuilder sb = new StringBuilder();




    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            arr.add(s);
        }
        Collections.sort(arr, Main::Comp);
        for (int i = 0; i < N; i++) {
            System.out.println(arr.get(i));
        }
    }

    public static int Comp(String a, String b) {
        if (a.length() == b.length()) {
            int asum = 0;
            int bsum = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) >= 48 && a.charAt(i) <= 57) {
                    asum += a.charAt(i) - '0';
                }
                if (b.charAt(i) >= 48 && b.charAt(i) <= 57) {
                    bsum += b.charAt(i) - '0';
                }
            }
            if (asum == bsum) {
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) != b.charAt(i)) {
                        return a.charAt(i) - b.charAt(i);
                    }
                }
            } else {
                return asum - bsum;
            }
        }
        return a.length() - b.length();
    }


}
