import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static int[] arr;
    static public class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static int[] dx = {1, 0,-1,0};
    static int[] dy = {0, 1,0,-1};

    static int N;
    static int M;
    static int MAX = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];

        int minus =0;
        int plus =0;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] > 0) plus++;
            else minus++;
        }

        Arrays.sort(arr);
        int temp = 1001;
        for (int i = 0; i < minus; i++) {
            if (temp == 1001) {
                temp = arr[i];
            } else {
                ans += temp * arr[i];
                temp = 1001;
            }
        }
        if (temp != 1001) {
            ans +=  temp;
            temp = 1001;
        }
        for (int i = N-1; i >= minus; i--) {
            if (arr[i] == 1) {
                ans += 1;
            } else if (temp == 1001) {
                temp = arr[i];
            } else {
                ans += temp * arr[i];
                temp = 1001;
            }
        }
        if (temp != 1001) {
            ans +=  temp;
            temp = 1001;
        }

        System.out.println(ans);


    }



}

