import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {

    static int L;
    static int C;
    static char[] arr;
    static char[] ans;
    static boolean[] chk;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        arr = new char[C];
        ans = new char[L];
        chk = new boolean[C];
        for (int i = 0; i < C; i++) {
            String s = sc.next();
            arr[i] = s.charAt(0);
        }
        Arrays.sort(arr);
        back(0, 0, 0 , 0);
        System.out.println(sb);

    }

    public static void back(int idx, int a, int sn, int bn) {
        if (idx == L) {
            if (sn >= 2 && bn >= 1) {
                for (int i = 0; i < L; i++) {
                    sb.append(ans[i]);
                }
                sb.append('\n');
                return;
            }
            else
                return;
        }
        for (int i = a; i < C; i++) {
            ans[idx] = arr[i];
            if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u')
                back(idx + 1, i + 1, sn, bn + 1);
            else
                back(idx + 1, i + 1, sn + 1, bn);
        }
    }


}
