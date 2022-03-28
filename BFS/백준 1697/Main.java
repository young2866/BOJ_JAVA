import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;


public class Main {

    static int N; // 수빈 위치
    static int K; // 동생 위치

    static int[] L;
    static boolean[] visited;
    static int count;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        L = new int[100001];
        visited = new boolean[100001];
        Arrays.fill(L, 1000001);
        q.offer(N);

        bfs();

    }

    public static void bfs() {
        visited[N] = true;
        L[N] = 0;

        while (!q.isEmpty()) {
            int temp = q.poll();
            int Next_U = temp + 1;
            int Next_D = temp - 1;
            int Next_2 = temp * 2;
            if (temp == K) {
                count = L[K];
                System.out.println(count);
                break;
            }
            if(Next_U <= 100000) {
                if (!visited[Next_U]) {
                    q.offer(Next_U);
                    visited[Next_U] = true;
                    L[Next_U] = L[temp] + 1;
                }
            }
            if(Next_D >= 0) {
                if (!visited[Next_D]) {
                    q.offer(Next_D);
                    visited[Next_D] = true;
                    L[Next_D] = L[temp] + 1;
                }
            }
            if (Next_2 <= 100000 && Next_2 > 0) {
                if(!visited[Next_2]){
                    q.offer(Next_2);
                    visited[Next_2] = true;
                    L[Next_2] =L[temp] + 1;
                }
            }
            }

        }
    }
