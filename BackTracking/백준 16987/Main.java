import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {

    static int N;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        back(0, 0);
        System.out.println(ans);

    }

    public static void back(int idx, int sum) {
        if (idx == N) {
            return;
        }
        for (int i = 0; i < N; i++) {
            if(i == idx || arr[i][0] <= 0) continue;
            if (arr[idx][0] <= 0) {
                back(idx + 1, sum);
                return;
            }
            arr[idx][0] -= arr[i][1];
            arr[i][0] -= arr[idx][1];
            int count = 0;
            if(arr[idx][0] <= 0)
                count++;
            if (arr[i][0] <= 0)
                count++;
            ans = max(ans, sum + count);
            back(idx + 1, sum + count);
            arr[idx][0] += arr[i][1];
            arr[i][0] += arr[idx][1];
        }
    }


}
