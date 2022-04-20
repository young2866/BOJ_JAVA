import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static Pair[] arr;
    static public class Pair implements Comparable<Pair>{
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.a == o.a) {
                return o.b - this.b;
            }
            return this.a - o.a;
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
        arr = new Pair[N];
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            arr[i] = new Pair(a * 100 + b, c * 100 + d);
        }
        Arrays.sort(arr);

        int end = 1201;
        int start = 301;
        int ans = 0;
        int now = 0;
        int idx = 0;
        while (start < end) {
            boolean chk = false;

            for (int i = idx; i < N; i++) {
                if(arr[i].a > start) break;

                if (now < arr[i].b) {
                    chk = true;
                    now = arr[i].b;
                    idx = i + 1;
                }
            }

            if (chk) {
                start = now;
                ans++;
            } else {
                break;
            }
        }
        if (now < end) {
            System.out.println("0");
        } else System.out.println(ans);





    }



}

