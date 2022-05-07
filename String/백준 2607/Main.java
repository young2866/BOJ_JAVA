import java.io.*;
import java.math.BigDecimal;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.max;


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[26];
        int count = 0;

        int N = Integer.parseInt(br.readLine());

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'A';
            arr[a]++;
        }

        for (int i = 1; i < N; i++) {
            int[] temp = arr.clone();
            int sum = 0;
            String s1 = br.readLine();
            if (s1.length() > s.length() + 1 || s1.length() + 1 < s.length()) {
                continue;
            } else {
                for (int j = 0; j < s1.length(); j++) {
                    int a = s1.charAt(j) - 'A';
                    if (temp[a] > 0) {
                        sum++;
                        temp[a]--;
                    }
                }
            }
            if(s1.length() == s.length() - 1 && sum == s1.length()) count++;
            else if (s1.length() == s.length()) {
                if(sum == s.length() - 1 || sum == s.length()) count++;
            } else if (s1.length() == s.length() + 1) {
                if(sum == s.length()) count++;
            }
        }
        System.out.println(count);



    }



}
