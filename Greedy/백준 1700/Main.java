import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;


public class Main {

    static int N;
    static int K;

    static int[] M;
    static int[] P;

    static ArrayList<Integer> list = new ArrayList<>();

    static int count = 0;
    static int out = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        P = new int[K + 1];

        for (int i = 0; i < K; i++) {
            int temp = sc.nextInt();
            P[i] = temp;
        }

        for (int i = 0; i < K; i++) {
            if (list.size() != N) {
                if (!list.contains(P[i])) {
                    list.add(P[i]);
                }
            } else {
                int temp = P[i];
                int chk = 0;
                for (int j = 0; j < N; j++) {
                    if (list.contains(temp)) {
                        chk = 9999;
                        break;
                    }
                }
                int MAX = 0;
                if (chk == 0) {
                    for (int j = 0; j < N; j++){
                        int ck = 0;
                        for (int x = i + 1; x < K; x++) {
                            if (list.get(j) == P[x]) {
                                MAX = max(MAX, x);
                                ck = 1;
                                if (MAX == x)
                                    out = j;
                                break;
                            }
                        }
                        if (ck == 0) {
                            out = j;
                            break;
                        }
                    }

                    list.remove(out);
                    list.add(temp);
                    count++;
                }

            }
        }

        System.out.println(count);
    }


}
