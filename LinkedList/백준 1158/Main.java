import java.io.*;
import java.util.*;

import static java.lang.Math.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> q = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }


        bw.write("<");
        while (!q.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                q.add(q.poll());
            }
            int temp = q.poll();
            if (!q.isEmpty()) {
                bw.write(temp + ", ");
            }else
                bw.write(temp+">");
        }
        bw.flush();



    }



}

