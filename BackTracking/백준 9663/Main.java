import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {

    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];

        back(0);
        System.out.println(count);
    }

    public static void back(int idx) {
        if (idx == N) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[idx] = i;

            if (Can(idx)) {
                back(idx + 1);
            }
        }
    }
    public static boolean Can(int idx) {
        for (int i = 0; i < idx; i++) {
            if(arr[idx] == arr[i] || idx - i == abs(arr[idx] - arr[i])) return false;
        }
        return true;
    }


}
