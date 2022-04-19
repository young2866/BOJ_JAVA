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


        arr = new int[3];
        if(N % 10 == 0) {
            while (true) {
                if (N >= 300) {
                    arr[0] = (N / 300);
                    N %= 300;
                } else if (N >= 60) {
                    arr[1] = arr[1] + (N / 60);
                    N %= 60;
                } else {
                    arr[2] = (N / 10);
                    break;
                }
            }
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
        }
        else{
            System.out.println("-1");
        }
    }



}

