import java.util.*;

import static java.lang.Math.max;

public class Main {

    static int T;
    static int N;

    static int[] Student;
    static boolean[] visited;
    static boolean[] finished;

    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int f = 0; f < T; f++) {
            N = sc.nextInt();
            Student = new int[N];
            visited = new boolean[N];
            finished = new boolean[N];
            for (int i = 0; i < N; i++) {
                Student[i] = sc.nextInt();
                Student[i]--;
            }
            count = 0;
            for (int i = 0; i < N; i++) {
                if(!visited[i]) dfs(i);
            }
            System.out.println(N-count);
        }
    }

    public static void dfs(int x) {
        visited[x] = true;
        int next = Student[x];
        if (visited[next]) {
            if(!finished[next]) {
                for (int temp = next; temp != x; temp = Student[temp]) count++;
                count++;
            }
        } else dfs(next);
        finished[x] = true;
    }

}
