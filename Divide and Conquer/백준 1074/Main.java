import java.util.*;



public class Main {

    static int N;
    static int r,c;
    static int s = 1;
    static int count = 0;

    public static void DC(int s, int e,int x,int y, int size) {
        if(size <= 1)
            return ;
        if (s + e == 0) {
            return ;
        }
        int nsize = size / 2;
        int chk;
        if(s < x + nsize && e < y + nsize)
            chk = 0;
        else if(s < x + nsize && e >= y + nsize)
            chk = 1;
        else if(s >= x + nsize && e < y + nsize)
            chk = 2;
        else
            chk = 3;

        count = count + (chk * nsize * nsize);


        if (chk == 0) {
            DC(s,e,x,y,nsize);
        } else if (chk == 1) {
            DC(s, e,x,y+nsize, nsize);
        } else if (chk == 2) {
            DC(s , e,x +nsize,y, nsize);
        } else {
            DC(s, e,x + nsize, y + nsize, nsize);
        }

    }





    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            s = s * 2;
        }

        r = sc.nextInt();
        c = sc.nextInt();


        DC(r, c,0, 0, s);
        System.out.println(count);

    }


}
