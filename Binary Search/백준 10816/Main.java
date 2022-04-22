import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static int[] arr;
    static int[] target;
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
    static int T;
    static int MAX = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();

            sb.append(solve(0, N, target) - solve2(0, N, target)).append(' ');
        }
        System.out.println(sb);
    }

    public static int solve(int start, int end, int target) {
        int count = 0;


        while (start < end) {

            int mid = (start + end) / 2;

            if (target < arr[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    public static int solve2(int start, int end, int target) {

        while (start < end) {

            int mid = (start + end) / 2;

            if (target <= arr[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }



}

