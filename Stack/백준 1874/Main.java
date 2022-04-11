import java.io.*;
import java.util.*;

import static java.lang.Math.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();

        int idx = 1; boolean chk = true;
        for (int i = 1; i <= N; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (idx < temp) {
                while (idx != temp) {
                    s.push(idx);
                    sb.append("+\n");
                    idx++;
                }
                sb.append("+\n");
                sb.append("-\n");
                idx++;
            } else if (idx > temp) {
                if (s.peek() == temp) {
                    sb.append("-\n");
                    s.pop();
                } else {
                    System.out.println("NO");
                    break;
                }
            } else if (idx == temp) {
                sb.append("+\n");
                sb.append("-\n");
                idx++;
            }
            if(i == N && chk)
                System.out.println(sb);
        }




    }



}

