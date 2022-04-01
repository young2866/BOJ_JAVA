import java.util.*;

import static java.lang.Math.*;


public class Main {

    static public class Three {
        int t,a,h;

        public Three(int t, int a, int h) {
            this.t = t;
            this.a = a;
            this.h = h;
        }
    }


    static int N; // 방 갯수
    static int H_ATK; // 용사의 초기 공격력
    static Three[] R;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        H_ATK = sc.nextInt();


        R = new Three[N];

        for (int i = 0; i < N; i++) {
            int temp1 = sc.nextInt();
            int temp2 = sc.nextInt();
            int temp3 = sc.nextInt();
            Three temp = new Three(temp1, temp2, temp3);

            R[i] = temp;
        }

        long l = 0; long h = 123456000000000000L;


        while (l +1 < h) {

            long H = (l + h) / 2;

            if (DND(H_ATK, H)) {
                h = H;
            }
            else l = H;
        }

        System.out.println(h);

    }

    public static boolean DND(long atk, long h) {
        long H = h;
        long ATK = atk;

        for (int i = 0; i < N; i++) {
            if (R[i].t == 1) {
                long cnt = R[i].h / ATK;
                if (R[i].h % ATK == 0) cnt--;

                H -= cnt * R[i].a;

                if (H <= 0) {
                    return false;
                }
            } else {
                ATK += R[i].a;
                H = min(h, H + R[i].h);
            }
        }
        return true;
    }

}
