import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> tree = new HashMap<>();

        String s = br.readLine();
        int count = 0;
        while (true) {
            if (!tree.containsKey(s)) {
                tree.put(s, 1);
            } else {
                tree.put(s, tree.get(s) + 1);
            }
            count++;
            s = br.readLine();
            if (s == null || s.length() == 0) {
                break;
            }
        }
        Object[] keys = tree.keySet().toArray();
        Arrays.sort(keys);

        for (Object key : keys) {
            String s1 = (String) key;
            int temp = tree.get(s1);
            double percent = (double) (temp * 100.0) / count;

            sb.append(s1 + " " + String.format("%.4f", percent) + "\n");
        }
        System.out.println(sb.toString());
    }


}
