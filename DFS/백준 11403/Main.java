import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int N;
    static int[][] Map;
    static int[][] Result;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        Map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Map[i][j] = sc.nextInt();
            }
        }
        for (int K = 0; K < N; K++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (Map[i][K] == 1 && Map[K][j] == 1) {
                        Map[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(Map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
