import java.io.*;
import java.util.*;

import static java.lang.Math.*;



public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[101];
        int sum = 0;
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        for (int i = 0; i < 3; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int j = a; j < b; j++) {
                arr[j] += 1;
            }
        }
        for (int i = 1; i < 101; i++) {
            if(arr[i] == 1)
                sum += A;
            else if(arr[i] == 2)
                sum += arr[i] * B;
            else if(arr[i] == 3)
                sum += arr[i] *C;
        }
        System.out.println(sum);

    }





}
