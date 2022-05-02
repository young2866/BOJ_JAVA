import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import static java.lang.Math.*;


public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> hm = new HashMap<>();
        int N = sc.nextInt();
        int M = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            hm.put(s, 1);
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            String s = sc.next();
            if (hm.containsKey(s)) {
                count++;
            }
        }
        System.out.println(count);

    }



}
