import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import static java.lang.Math.*;


public class Main {

    static StringBuilder sb = new StringBuilder();




    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();

        int count = 0; int min = 999999;
        for (int i = 0; i <= B.length() - A.length(); i++) {
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(j + i)) {
                    count++;
                }
            }
            if (count < min) {
                min = count;
            }
            count = 0;
        }
        System.out.println(min);
    }



}
