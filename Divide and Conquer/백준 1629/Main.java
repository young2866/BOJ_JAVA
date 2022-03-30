import java.util.*;


public class Main {

    static long  A, B, C;

    public static long PC(long a, long b) {
        if (b == 1) {
            return a % C;
        }
        if (b % 2 == 0) {
            long temp = PC(a, b / 2);
            return (temp * temp) % C;
        } else {
            return PC(a, b - 1) * a % C;
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextLong();
        B = sc.nextLong();
        C = sc.nextLong();

        System.out.println(PC(A,B));

    }


}
