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

        Stack<Pair> tower = new Stack<>();


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (tower.isEmpty()) {
                bw.write("0 ");
                tower.push(new Pair(temp, i));
            } else if (tower.peek().H > temp) {
                bw.write(tower.peek().idx + " ");
                tower.push(new Pair(temp, i));
            } else if (tower.peek().H < temp) {
                while (!tower.isEmpty()) {
                    tower.pop();
                    if (tower.isEmpty()) {
                        bw.write("0 ");
                        tower.push(new Pair(temp, i));
                        break;
                    } else {
                        if (tower.peek().H > temp) {
                            bw.write(tower.peek().idx+" ");
                            tower.push(new Pair(temp, i));
                            break;
                        }
                    }
                }
            }
        }
        bw.flush();



    }



}

