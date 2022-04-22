import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {
    static long[] arr;
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

        arr = new long[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextLong();
        Arrays.sort(arr);
        Pair temp = solve();

        System.out.println(arr[temp.a] + " " + arr[temp.b]);


    }

    public static Pair solve() {
        int start = 0;
        int end = N - 1;
        int first=start;
        int second=end;

        while (start < end) {
            long sum = arr[start] + arr[end];

            if(abs(sum) < abs(MIN)) {
                MIN = sum;
                first = start;
                second = end;
            }

            if(sum < 0)
                start++;
            else
                end--;
        }
        return new Pair(first, second);
    }





}

