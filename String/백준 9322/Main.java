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
            String[] key = new String[N];
            String[] ans = new String[N];
            HashMap<String,Integer> hm = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String s = sc.next();
                hm.put(s, i);
            }
            for (int i = 0; i < N; i++) {
                key[i] = sc.next();
            }
            for (int i = 0; i < N; i++) {
                String s = sc.next();
                int temp = hm.get(key[i]);
                ans[temp] = s;
            }
            for (int i = 0; i < N; i++) {
                sb.append(ans[i]).append(' ');
            }
            System.out.println(sb);
            sb.setLength(0);
            hm.clear();

        }

    }



}
