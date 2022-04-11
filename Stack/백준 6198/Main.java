import java.io.*;
import java.util.*;

import static java.lang.Math.*;


public class Main {
    public static class Pair {
        int H; int idx;

        public Pair(int H, int idx) {
            this.H = H;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> tower = new Stack<>();

        long ans = 0;
        int temp = Integer.parseInt(br.readLine());
        tower.push(temp);
        for (int i = 1; i < N; i++) {
            temp = Integer.parseInt(br.readLine());
            if (tower.peek() > temp) {
                ans += tower.size();
                tower.push(temp);
            } else if (tower.peek() <= temp) {
                while (!tower.isEmpty()) {
                    tower.pop();
                    if (tower.isEmpty()) {
                        tower.push(temp);
                        break;
                    } else {
                        if (tower.peek() > temp) {
                            ans += tower.size();
                            tower.push(temp);
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(ans);

    }



}

