import java.util.*;

public class Main {

    static int N;
    static int X;
    static int Y;

    static int M;
    static int[][] Family;
    static int[] dis;

    static int res = -1;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        Family = new int[N + 1][N + 1];
        dis = new int[N + 1];
        X = sc.nextInt();
        Y = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            Family[a][b] = 1;
            Family[b][a] = 1;
        }

        bfs(X,Y);

        System.out.println(res);
    }

    public static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            if (temp == end) {
                res = dis[temp];
                break;
            }

            for (int i = 1; i <= N; i++) {
                if (Family[temp][i] == 1 && dis[i] == 0) {
                    dis[i] = dis[temp]+1;
                    queue.offer(i);
                }
            }
        }

    }

}
