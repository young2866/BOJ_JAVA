import java.io.*;
import java.math.BigDecimal;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.max;


public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hm = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            hm.put(s, i);
        }
        int count = 0;
        int[] out = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            out[i] = hm.get(s);
        }
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (out[i] > out[j]) {
                    count++;
                    break;
                }
            }
        }


        System.out.println(count);
    }


}
