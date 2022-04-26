import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static int N;
    static int S;
    static int[] arr;
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        back(0, 0);
        if (S == 0) {
            count--;
            System.out.println(count);
        }else System.out.println(count);
    }

    public static void back(int idx, int sum) {
        if (idx == N) {
            if (sum == S) {
                count++;
            }
            return;
        }
        back(idx + 1, sum);
        back(idx + 1, sum + arr[idx]);
    }


    }
