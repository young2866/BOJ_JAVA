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
        target = new int[M];
        for(int i = 0; i < M; i++)
            target[i] = sc.nextInt();
        for (int i = 0; i < M; i++) {
            solve(N - 1, target[i]);
        }

    }

    public static void solve(int size, int target) {
        int s = 0;
        int end = size;
        int mid;
        while (end - s >= 0) {
            mid = (s + end) / 2;
            if (arr[mid] == target) {
                System.out.println(1);
                return;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        System.out.println("0");
        return;
    }



}

