import java.io.*;
import java.util.*;

import static java.lang.Math.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int  N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            LinkedList<Character> ll = new LinkedList<>();
            ListIterator<Character> iter = ll.listIterator();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (c == 60) {
                    if(iter.hasPrevious())
                        iter.previous();
                } else if (c == 62) {
                    if(iter.hasNext())
                        iter.next();
                } else if (c == 45) {
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                } else {
                    iter.add(c);
                }
            }
            for (Character p : ll) {
                bw.write(p);
            }
            bw.write("\n");
            bw.flush();
        }

        bw.close();


    }



}

