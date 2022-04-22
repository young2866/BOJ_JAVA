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
        M = sc.nextInt();
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int count = 0; target = new int[M];
        for (int i = 0; i < M; i++) {
            target[i] = sc.nextInt();
        }
        Arrays.sort(target);
        for (int i = 0; i < N; i++) {
            if (!solve(0, M - 1, arr[i])) {
                count++;
                sb.append(arr[i]).append(' ');
            }
        }
        if (count == 0) {
            System.out.println("0");
        } else {
            System.out.println(count);
            System.out.println(sb);
        }
    }

    public static boolean solve(int start, int end, int key) {


        while (start <= end) {

            int mid = (start + end) / 2;
            if (target[mid] == key) {
                return true;
            }

            if (key < target[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }




}

