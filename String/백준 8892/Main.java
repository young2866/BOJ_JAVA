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
            int N = sc.nextInt();
            String[] arr = new String[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.next();
            }
            String ans = "";
            for (int i = 0; i < N ; i++) {
                for (int j = 0; j < N; j++) {
                    if(i == j) continue;
                    String temp = arr[i] + arr[j];
                    int lo = 0;
                    int hi = temp.length() - 1;
                    boolean chk = true;
                    while (lo <= hi) {
                        if (temp.charAt(lo++) != temp.charAt(hi--)) {
                            chk = false;
                            break;
                        }
                    }
                    if(chk)
                        ans = temp;
                }
                if(!ans.equals(""))
                    break;
            }
            if (ans.equals("")) {
                System.out.println("0");
            }else System.out.println(ans);
        }



    }



}
