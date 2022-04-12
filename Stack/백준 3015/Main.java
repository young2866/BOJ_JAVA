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

        Stack<Pair> nums = new Stack<>();

        int temp = Integer.parseInt(br.readLine());

        nums.push(new Pair(temp, 0));

        long ans = 0;

        for (int i = 1; i < N; i++) {
            temp = Integer.parseInt(br.readLine());
            if (nums.isEmpty()) {
                nums.push(new Pair(temp, 0));
            } else {
                if (nums.peek().H > temp) {
                    ans++;
                    nums.push(new Pair(temp, 0));
                } else if (nums.peek().H == temp) {
                    ans += nums.peek().idx + 1;
                    if(nums.size() != nums.peek().idx + 1)
                        ans++;
                    nums.push(new Pair(temp, nums.peek().idx + 1));
                } else {
                    while (!nums.isEmpty()) {
                        nums.pop();
                        ans++;
                        if (!nums.isEmpty() && nums.peek().H > temp) {
                            ans++;
                            nums.push(new Pair(temp, 0));
                            break;
                        } else if (!nums.isEmpty() && nums.peek().H == temp) {
                            ans += nums.peek().idx + 1;
                            if(nums.size() != nums.peek().idx + 1)
                                ans++;
                            nums.push(new Pair(temp, nums.peek().idx + 1));
                            break;
                        }
                    }
                    if (nums.isEmpty()) {
                        nums.push(new Pair(temp, 0));
                    }
                }
            }
        }
        System.out.println(ans);

    }



}

