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
    static Long MIN = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < N; i++) {
            count += solve(arr[i], i);
        }

        System.out.println(count);

    }

    public static int solve(int target, int idx) {
        int start = 0;
        int end = N - 1;

        if(start == idx) start++;
        if(end == idx) end--;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if(sum == target)
                return 1;

            if (sum < target) {
                start++;
                if(start == idx)
                    start++;
            } else {
                end--;
                if(end == idx)
                    end--;
            }
        }
        return 0;
    }





}