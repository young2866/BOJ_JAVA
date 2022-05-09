import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hm = new HashMap<>();
        String s = br.readLine();

        int count = 0;
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - idx; j++) {
                if (!hm.containsKey(s.substring(j, j + idx + 1))) {
                    hm.put(s.substring(j, j + idx + 1), 1);
                }
            }
            idx++;
        }
        System.out.println(hm.size());
    }


}
