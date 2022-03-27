import java.util.*;



public class Main {

    static class START {
        int x,y,z;

        START(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static class END {
        int x,y,z;

        END(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static char[][][] B;
    static int[][][] visited;

    static int L;
    static int R;
    static int C;
    static START S;
    static END E;

    static int[] d_x = {0, 0, 0, 0, -1, 1};
    static int[] d_y = {0, 0, -1, 1, 0, 0};
    static int[] d_z = {1, -1, 0, 0, 0, 0};



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        R = sc.nextInt();
        C = sc.nextInt();

        B = new char[L][R][C];
        visited = new int[L][R][C];

        while (L + R + C != 0) {
            for (int x = 0; x < L; x++) {
                for (int y = 0; y < R; y++) {
                    String s = sc.next();
                    for (int z = 0; z < C; z++) {
                        B[x][y][z] = s.charAt(z);
                        if(B[x][y][z] == 'S')
                            S = new START(x, y, z);
                        else if(B[x][y][z] == 'E')
                            E = new END(x, y, z);
                    }
                }
            }

            bfs();

            if (visited[E.x][E.y][E.z] != 0) {
                System.out.println("Escaped in " + (visited[E.x][E.y][E.z] - 1) +" minute(s).");
            }
            else
                System.out.println("Trapped!");

            L = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();

            B = new char[L][R][C];
            visited = new int[L][R][C];
        }

    }

    public static void bfs() {
        Queue<int []> q = new LinkedList<>();
        q.add(new int[] {S.x, S.y, S.z});
        visited[S.x][S.y][S.z] = 1;

        while (!q.isEmpty()) {
            int curr[] = q.poll();
            int curr_X = curr[0];
            int curr_Y = curr[1];
            int curr_Z = curr[2];

            for (int i = 0; i < 6; i++) {
                int dx = curr_X + d_x[i];
                int dy = curr_Y + d_y[i];
                int dz = curr_Z + d_z[i];
                if (dx >= 0 && dy >= 0 && dz >= 0 && dx < L && dy < R && dz < C) {
                    if (visited[dx][dy][dz] == 0 && B[dx][dy][dz] != '#') {
                        q.add(new int[] {dx, dy, dz});
                        visited[dx][dy][dz] = visited[curr_X][curr_Y][curr_Z] + 1;
                    }
                }
            }
        }


    }

}
