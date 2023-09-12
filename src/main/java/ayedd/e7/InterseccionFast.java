package ayedd.e7;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;

public class InterseccionFast {

    public static int[] buscar_interseccion_fast(int[] l1, int[] l2){
        int contador = 0;
        int [] almacen = new int[l1.length + l2.length];
        Arrays.sort(l2);

        for (int i = 0; i < l1.length; i++){

            int lo = 0;
            int hi = l2.length - 1;

            while (lo <= hi)
            {
                int mid = lo + (hi - lo) / 2;
                if      (l1[i] < l2[mid]) hi = mid - 1;
                else if (l1[i] > l2[mid]) lo = mid + 1;
                else{
                    almacen[contador] = l1[i];
                    contador++;
                    break;
                    }
                }
            while (l1[i] == l1[i + 1]){
                i++;
            }

        }
        int[] result = new int[contador];
        for (int i = 0; i < contador; i++){
            result[i] = almacen[i];
        }
        return result;
    }

    public static void main(String[] args) {
        In in1 = new In(args[0]);
        int[] list1 = in1.readAllInts();
        In in2 = new In(args[0]);
        int[] list2 = in2.readAllInts();
        int[] result = buscar_interseccion_fast(list1, list2);
        for (int i = 0; i < result.length; i++) {
            StdOut.println(result[i]);
        }

    }
}
