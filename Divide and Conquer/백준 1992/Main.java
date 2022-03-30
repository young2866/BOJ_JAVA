import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;


public class Main {

    static int N;
    static int[][] A;

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
            System.out.print(A[r][c]);
        } else {
            int psize = size / 2;
            System.out.print("(");
            DC(r, c, psize);
            DC(r, c + psize, psize);

            DC(r + psize, c, psize);
            DC(r + psize, c + psize, psize);
            System.out.print(")");
        }
    }





    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                A[i][j] = s.charAt(j) - '0';
            }
        }
        DC(0, 0, N);
        System.out.println();

    }


}
