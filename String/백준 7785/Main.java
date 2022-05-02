import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import static java.lang.Math.*;


public class Main {

    static StringBuilder sb = new StringBuilder();




    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        ArrayList<String> arr = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str1 = sc.next();
            String str2 = sc.next();

            if (str2.equals("enter")) {
                if (!hm.containsKey(str1)) {
                    hm.put(str1, 1);
                    arr.add(str1);
                } else {
                    hm.put(str1, 1);
                }
            } else {
                if (hm.containsKey(str1)) {
                    hm.put(str1, 0);
                }
            }
        }
        Collections.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < arr.size(); i++) {
            if (hm.get(arr.get(i)) == 1) {
                sb.append(arr.get(i)).append('\n');
            }
        }
        System.out.println(sb);
    }



}
