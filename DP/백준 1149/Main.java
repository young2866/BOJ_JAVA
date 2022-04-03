import java.util.*;

import static java.lang.Math.min;


public class Main {

    static int N;
    static int[][] cost;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        cost = new int[N+1][3];

        for (int i = 1; i <= N; i++) {
            int R = sc.nextInt();
            int G = sc.nextInt();
            int B = sc.nextInt();

            cost[i][0] = min(cost[i-1][1], cost[i-1][2]) + R;
            cost[i][1] = min(cost[i-1][0], cost[i-1][2]) + G;
            cost[i][2] = min(cost[i-1][0], cost[i-1][1]) + B;
        }

        System.out.println(min(cost[N][0], min(cost[N][1], cost[N][2])));

    }



}

