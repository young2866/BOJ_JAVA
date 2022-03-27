import java.util.*;



public class Main {

    static class Pair {
        int x,y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static int N;
    static int M;

    static int[][] Map;
    static boolean[][] visited;


    static int[] d_x = {0, 0, -1, 1};
    static int[] d_y = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        Map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                Map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(Map[N-1][M-1]);
    }

    public static void bfs() {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0,0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int dx = temp.x + d_x[i];
                int dy = temp.y + d_y[i];

                if (dx >= 0 && dy >= 0 && dx < N && dy < M) {
                    if (!visited[dx][dy] && Map[dx][dy] != 0) {
                        queue.offer(new Pair(dx,dy));
                        Map[dx][dy] = Map[temp.x][temp.y] + 1;
                        visited[dx][dy] = true;
                    }
                }
            }

        }

    }

}
