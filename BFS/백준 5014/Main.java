import java.util.*;

import static java.lang.Math.max;


public class Main {

    static int F; // 층
    static int S; // 현재 위치
    static int G; // 목적지
    static int U, D; // 버튼

    static int count = 0;

    static int[] B;
    static boolean[] visited;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        B = new int[F + 1];
        visited = new boolean[F + 1];

        bfs();

    }

    public static void bfs() {
        B[S] = 0;
        q.offer(S);
        visited[S] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();
            int Next_U = temp + U;
            int Next_D = temp - D;
            if (temp == G) {
                count = B[G];
                System.out.println(count);
                break;
            }
            if(Next_U <= F) {
                if (!visited[Next_U]) {
                    q.offer(Next_U);
                    visited[Next_U] = true;
                    B[Next_U] = B[temp] + 1;
                }
            }
            if(Next_D > 0) {
                if (!visited[Next_D]) {
                    q.offer(Next_D);
                    visited[Next_D] = true;
                    B[Next_D] = B[temp] + 1;
                }
            }

        }
        if(!visited[G])
            System.out.println("use the stairs");
        }
    }
