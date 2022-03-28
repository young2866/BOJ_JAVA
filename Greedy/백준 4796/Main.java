import java.util.*;


public class Main {

    static int L;
    static int P;
    static int V; // 휴가 일 수

    static int Case = 1;

    static int ans;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        P = sc.nextInt();
        V = sc.nextInt();

        while (L + P + V != 0) {
            if (V % P <= L)
                ans = (V / P) * L + (V % P);
            else
                ans = (V / P) * L + L;

            System.out.println("Case " + Case + ": " + ans);
            L = sc.nextInt();
            P = sc.nextInt();
            V = sc.nextInt();
            Case++;
        }

    }


}
