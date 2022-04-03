import java.util.*;

import static java.lang.Math.min;


public class Main {

    static char[] str1;
    static char[] str2;

    static int[][] dp;
    static char[] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        str1 = sc.nextLine().toCharArray();
        str2 = sc.nextLine().toCharArray();

        dp = new int[str1.length + 1][str2.length + 1];

        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {

                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        ans = new char[dp[str1.length][str2.length]];
        int pos = ans.length-1;
        int strl1 = str1.length, strl2 = str2.length;

        while (true) {
            if(dp[strl1][strl2] == dp[strl1-1][strl2])
                strl1--;
            else if(dp[strl1][strl2] == dp[strl1][strl2-1])
                strl2--;
            else {
                ans[pos] = str1[strl1-1];
                pos--;
                strl1--;
                strl2--;
            }
            if(pos == -1)
                break;
        }
        System.out.println(dp[str1.length][str2.length]);
        System.out.println(ans);
    }


}

