import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import static java.lang.Math.*;


public class Main {


    static int N;
    static boolean[] chk;
    static char[] arr;
    static int[] temp;
    static ArrayList<String> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        chk = new boolean[10];
        arr = new char[N];
        temp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            arr[i] = s.charAt(0);
        }
        func(0, "", -1);
        Collections.sort(ans);
        System.out.println(ans.get(ans.size() - 1));
        System.out.println(ans.get(0));

    }
    public static void func(int idx, String str, int a) {
        if (idx == N + 1) {
            ans.add(str);
            return;
        }
        if (idx == 0) {
            for (int i = 0; i < 10; i++) {
                temp[idx] = i;
                chk[i] = true;
                func(idx + 1, str + i, i);
                chk[i] = false;
            }
        } else {
            for (int i = 0; i < 10; i++) {
                if(chk[i]) continue;
                temp[idx] = i;
                if (arr[idx - 1] == '<' && a < i) {
                    chk[i] = true;
                    func(idx + 1, str + i, i);
                    chk[i] = false;
                } else if (arr[idx - 1] == '>' && a > i) {
                    chk[i] = true;
                    func(idx + 1, str + i, i);
                    chk[i] = false;
                }
            }
        }
    }
}
