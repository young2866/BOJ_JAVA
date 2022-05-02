import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import static java.lang.Math.*;


public class Main {

    static StringBuilder sb = new StringBuilder();

    public static int len(String a, String b) {
        if (a.length() == b.length()) {
            for (int i = 0; i < a.length(); i++) {
                if(a.charAt(i) != b.charAt(i))
                    return a.charAt(i) - b.charAt(i);
            }
        }
        return a.length() - b.length();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }
        Arrays.sort(arr, Main::len);
        String temp = "";
        for (int i = 0; i < N; i++) {
            if (!temp.equals(arr[i])) {
                System.out.println(arr[i]);
                temp = arr[i];
            }
        }



    }



}
