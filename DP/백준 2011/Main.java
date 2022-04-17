import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static int[] dp;
    static int[]arr;
    static public class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        arr = new int[s.length() + 1];
        dp = new int[s.length() + 1];

        for(int i = 0; i < s.length(); i++)
            arr[i + 1] = s.charAt(i)-'0';

        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (arr[i] != 0) {
                dp[i] += dp[i - 1] % 1000000;
            }
            int temp = arr[i] + arr[i-1] * 10;

            if (temp >= 10 && temp <= 26) {
                dp[i] += dp[i-2] % 1000000;
            }
        }
        System.out.println(dp[s.length()] % 1000000);



   }



}
