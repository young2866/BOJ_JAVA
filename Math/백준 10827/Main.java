import java.io.*;
import java.math.BigDecimal;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.max;


public class Main {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BigDecimal N = new BigDecimal(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        System.out.println(N.pow(M).toPlainString());

    }



}
