package ayedd.e7;

import edu.princeton.cs.algs4.*;

public class Interseccion {

    public static int[] buscar_interseccion(int[] l1, int[] l2){
        int contador = 0;
        int [] almacen = new int[l1.length + l2.length];

        for (int i = 0; i < l1.length; i++){
            boolean nuevo = true;
            for (int k = 0; k <= contador; k++) {
                if (l1[i] == almacen[k]) {
                    nuevo = false;

                }
            }
                if (nuevo){
                    for (int j = 0; j < l2.length; j++){
                        if (l1[i] == l2[j]){
                            almacen[contador] = l1[i];
                            contador++;
                            break;
                        }
                    }
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
        int[] result = buscar_interseccion(list1, list2);
        for (int i = 0; i < result.length; i++) {
            StdOut.println(result[i]);
        }

    }
}
