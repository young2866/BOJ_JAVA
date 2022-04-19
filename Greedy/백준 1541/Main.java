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

        int sum = Integer.MAX_VALUE;


        StringTokenizer st = new StringTokenizer(sc.nextLine(), "-");
        while (st.hasMoreTokens()) {
            int temp = 0;
            StringTokenizer st1 = new StringTokenizer(st.nextToken(), "+");

            while (st1.hasMoreTokens()) {
                temp += Integer.parseInt(st1.nextToken());
            }

            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }



}

