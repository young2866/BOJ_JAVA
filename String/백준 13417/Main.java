import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Deque<Character> dq = new ArrayDeque<>();
            String s = br.readLine();
            for (int i = 0; i < s.length(); i += 2) {
                if (i == 0) {
                    dq.addFirst(s.charAt(i));
                } else {
                    if (dq.peekFirst() >= s.charAt(i)) {
                        dq.addFirst(s.charAt(i));
                    } else {
                        dq.addLast(s.charAt(i));
                    }
                }
            }
            while (!dq.isEmpty()) {
                sb.append(dq.pollFirst());
            }
            System.out.println(sb);
            sb.setLength(0);

        }
    }


}
