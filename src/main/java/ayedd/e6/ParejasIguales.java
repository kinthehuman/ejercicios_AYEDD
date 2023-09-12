package ayedd.e6;

import edu.princeton.cs.algs4.*;

public class ParejasIguales {

    public static int buscar_parejas(int[] l1){
        int contador = 0;
        for (int i = 0; i < l1.length; i++){
            for (int j = i + 1; j < l1.length; j++){
                if (l1[i] == l1[j]){
                    contador++;
                }
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        In in1 = new In(args[0]);
        int[] list1 = in1.readAllInts();
        int[] list1 = new int[10];
        int result = buscar_parejas(list1);
        StdOut.println(result);

    }
}
