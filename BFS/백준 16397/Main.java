import java.util.*;


public class Main {

    static int N; // 다섯자리 십진수
    static int T; // 버튼 횟수
    static int G; // 탈출 수

    static int[] L;
    static boolean[] visited;
    static int count;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        T = sc.nextInt();
        G = sc.nextInt();

        L = new int[100001];
        visited = new boolean[100001];
        q.offer(N);

        bfs();

        if (!visited[G]) {
            System.out.println("ANG");
        }
        else if (L[G] > T)
            System.out.println("ANG");
        else
            System.out.println(L[G]);

    }

    public static void bfs() {
        visited[N] = true;
        L[N] = 0;

        while (!q.isEmpty()) {
            int temp = q.poll();
            int Next_A = temp + 1;
            int Next_B = temp * 2;
            if(Next_B != 0 && Next_B <= 99999)
            for (int i = 10000; i > 0; ) {
                if (Next_B / i > 0) {
                    Next_B = Next_B - i;
                    break;
                }
                else
                    i /= 10;
            }
            if (temp == G) {
                break;
            }
            if(Next_A <= G) {
                if (!visited[Next_A]) {
                    q.offer(Next_A);
                    visited[Next_A] = true;
                    L[Next_A] = L[temp] + 1;
                }
            }
            if(Next_B > 0 && Next_B <100000) {
                if (!visited[Next_B]) {
                    q.offer(Next_B);
                    visited[Next_B] = true;
                    L[Next_B] = L[temp] + 1;
                }
            }


            }

        }
    }
