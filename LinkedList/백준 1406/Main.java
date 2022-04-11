import java.io.*;
import java.util.*;

import static java.lang.Math.*;


public class Main {

    static LinkedList<Character> ll = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            ll.addLast(s.charAt(i));
        }
        ListIterator<Character> iter = ll.listIterator();
        while (iter.hasNext()) {
            iter.next();
        }

        int  N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s1 = br.readLine();
            char cmd = s1.charAt(0);
            switch (cmd) {
                case 'L':
                    if(iter.hasPrevious())
                        iter.previous();
                    break;
                case 'D':
                    if(iter.hasNext())
                        iter.next();
                    break;
                case 'B':
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char a = s1.charAt(2);
                    iter.add(a);
                    break;
                default:
                    break;
            }
        }

        for (Character p : ll) {
            bw.write(p);
        }

        bw.flush();
        bw.close();


    }



}

