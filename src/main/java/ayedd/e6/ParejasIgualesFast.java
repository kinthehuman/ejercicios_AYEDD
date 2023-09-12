package ayedd.e6;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ParejasIgualesFast {

    public static int buscar_parejas_fast(int[] l1){
        int contador = 0;
        Arrays.sort(l1);
        for (int i = 0; i < l1.length;){
            int j = 1;
            while (i + j < l1.length && l1[i] == l1[i+j]){
                contador = contador + j;
                j++;
            }
            i = i + j;
        }
        return contador;
    }

    public static void main(String[] args) {
        In in1 = new In(args[0]);
        int[] list1 = in1.readAllInts();
        int[] list1 = new int[100000000];
        int result = buscar_parejas_fast(list1);
        StdOut.println(result);

    }
}
