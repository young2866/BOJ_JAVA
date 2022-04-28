import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {


    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int idx = 5; int count = 0;
            while (true) {
                if (N / idx == 0) {
                    break;
                } else {
                    count += N / idx;
                    idx *= 5;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }



}
