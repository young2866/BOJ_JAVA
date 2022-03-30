import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;


public class Main {

    static int N;
    static int[][] A;

    static int[] count = new int[3];

    public static void DC(int r, int c, int size) {
        int chk = 1;
        for (int i = r; i < r+size; i++) {
            for (int j = c; j < c+size; j++) {
                if (A[i][j] != A[r][c]) {
                    chk = 2;
                    break;
                }
            }
            if(chk == 2)
                break;
        }

        if (chk == 1) {
            if (A[r][c] == -1) {
                count[0]++;
            } else {
                count[A[r][c] + 1]++;
            }
        } else {
            int psize = size / 3;

            DC(r, c, psize);
            DC(r, c + psize, psize);
            DC(r, c+ psize*2 , psize);

            DC(r + psize, c, psize);
            DC(r + psize, c + psize, psize);
            DC(r + psize, c + psize*2, psize);

            DC(r + psize*2, c, psize);
            DC(r + psize*2, c + psize, psize);
            DC(r + psize*2, c + psize*2, psize);
        }
    }





    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        A = new int[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                int temp = sc.nextInt();
                A[i][j] = temp;
            }

        DC(0, 0, N);
        System.out.println(count[0]);
        System.out.println(count[1]);
        System.out.println(count[2]);

    }


}
