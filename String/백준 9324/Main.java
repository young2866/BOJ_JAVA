import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import static java.lang.Math.*;


public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            int[] arr = new int[26];
            boolean chk = true;
            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                int temp = s.charAt(j) - 'A';
                arr[temp]++;
                if (arr[temp] % 3== 0) {
                    if (j + 1 >= s.length()) {
                        chk = false;
                    } else {
                        if (s.charAt(j) == s.charAt(j + 1)) {
                            arr[temp] = 0;
                            j += 1;
                        } else {
                            chk = false;
                            break;
                        }
                    }
                }
            }
            System.out.println(chk ? "OK" : "FAKE");
        }



    }



}
