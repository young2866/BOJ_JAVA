import java.util.*;



public class Main {
    static class Pair {
        int x,y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] B;

    static int T;
    static int L;
    static Pair curr;
    static Pair end;


    static int[] d_x = {1, 2, -1, -2, 1, 2, -1, -2};
    static int[] d_y = {2, 1, -2, -1, -2, -1, 2, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int x = 0; x < T; x++) {
            L = sc.nextInt();
            B = new int[L][L];


            int temp_1 = sc.nextInt();
            int temp_2 = sc.nextInt();
            int temp_3 = sc.nextInt();
            int temp_4 = sc.nextInt();

            curr = new Pair(temp_1, temp_2);
            end = new Pair(temp_3, temp_4);

            bfs();

            System.out.println(B[end.x][end.y] - 1);
        }
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {curr.x,curr.y});
        B[curr.x][curr.y] = 1;

        while (!q.isEmpty()) {
            int curr[] = q.poll();
            int curr_X = curr[0];
            int curr_Y = curr[1];

            for (int i = 0; i < 8; i++) {
                int Next_X = curr_X + d_x[i];
                int Next_Y = curr_Y + d_y[i];
                if (Next_X >= 0 && Next_Y >= 0 && Next_X < L && Next_Y < L) {
                    if (B[Next_X][Next_Y] == 0) {
                        q.add(new int[]{Next_X, Next_Y});
                        B[Next_X][Next_Y] = B[curr_X][curr_Y] + 1;
                    }
                }
            }
        }
    }

}
