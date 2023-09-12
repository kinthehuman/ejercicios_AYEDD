package ayedd.e2;
import java.util.Arrays;
import edu.princeton.cs.algs4.*;
public class Separador {

    public static int[] separa(int[] a){
        int n = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i] < 0){n++;}
        }
        for (int i = 0; i < n; i++){
            if (a[i] >= 0){
                int vp = a[i];
                for (int y = n; y < a.length; y++){
                    if (a[y] < 0){
                        int vn = a[y];
                        a[i] = vn;
                        a[y] = vp;
                        break;
                    }
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("ERROR: Introduzca 1 parametro");
            System.exit(1);
        }

        In in = new In(args[0]);
        int[] list = in.readAllInts();

        separa(list);
        StdOut.println(Arrays.toString(list));

    }
}
