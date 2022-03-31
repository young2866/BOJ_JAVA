import java.util.*;



public class Main {

    static int N;
    static int s = 1;
    static char[][] B;

    public static void DC(int s, int e,int size) {
        if (size == 1) {
            B[s][e] = '*';
        } else {
            int nsize = size / 3;

            DC(s, e, nsize);
            DC(s, e + nsize, nsize);
            DC(s, e + 2 * nsize, nsize);

            DC(s + nsize, e, nsize);
            DC(s + nsize, e + 2 * nsize, nsize);

            DC(s + 2 * nsize, e, nsize);
            DC(s + 2 * nsize, e + nsize, nsize);
            DC(s + 2 * nsize, e + 2 * nsize, nsize);
        }

    }





    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        B = new char[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(B[i], ' ');
        }


        DC(0,0,N);

        for (int i = 0; i < N; i++) {
            System.out.println(B[i]);
        }

    }


}
