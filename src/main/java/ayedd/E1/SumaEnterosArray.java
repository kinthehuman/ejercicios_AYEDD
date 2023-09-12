package ayedd.E1;
import java.util.Arrays;
import edu.princeton.cs.algs4.*;
public class SumaEnterosArray {

    public static void formato(int[] a, String doc){
        int error = 0;
        for (int i = 0; i < a.length; i++) {
            if ((a[i] < 0) || (a[i] > 9)) {
                System.err.println("ERROR: La fila " + i + " de (" + doc + ") de valor " + a[i] + " no es una cifra comprendida entre 0 y 9.");
                error = 1;
            }
        }
        if (error == 1){
            System.exit(1);
        }
    }

    public static int[] suma(int[] n1, int[] n2){
        int dif = n1.length - n2.length;
        int acarreo = 0;
        if (dif > 0) {
            for (int i = 1; i <= n2.length; i++) {
                int acarreold = acarreo;
                acarreo = (n2[n2.length - i] + n1[n1.length - i] + acarreo) / 10;
                n1[n1.length - i] = (n2[n2.length - i] + n1[n1.length - i] + acarreold) % 10;                
            }
            for (int i = dif - 1; i >= 0; i--){
                int acarreold = acarreo;
                acarreo = (n1[i] + acarreo) / 10;
                n1[i] = (n1[i] + acarreold) % 10;
                
                if (acarreo == 0)  {return n1;}
            }
                int[] newresult = new int[n1.length + 1];
                newresult[0] = acarreo;
                for (int i = 0; i < n1.length; i++) {
                    newresult[i + 1] = n1[i];
                }
                return newresult;
        }
        else if (dif < 0){
            for (int i = 1; i <= n1.length; i++) {
                int acarreold = acarreo;
                acarreo = (n2[n2.length - i] + n1[n1.length - i] + acarreo) / 10;
                n2[n2.length - i] = (n2[n2.length - i] + n1[n1.length - i] + acarreold) % 10;
            }
            for (int i = - dif - 1; i >= 0; i--){
                int acarreold = acarreo;
                acarreo = (n2[i] + acarreo) / 10;
                n2[i] = (n2[i] + acarreold) % 10;
                if (acarreo == 0) {return n2;}
            }
                int[] newresult = new int[n2.length + 1];
                newresult[0] = acarreo;
                for (int i = 0; i < n2.length; i++) {
                    newresult[i + 1] = n2[i];
                }
                return newresult;
        }
        else {
            for (int i = n1.length - 1; i >= 0; i--) {
                int acarreold = acarreo;
                acarreo = (n2[i] + n1[i] + acarreo) / 10;
                n1[i] = (n2[i] + n1[i] + acarreold) % 10;                
            }
            
            if (acarreo == 0)  {return n1;}
            
            int[] newresult = new int[n1.length + 1];
            newresult[0] = acarreo;
            for (int i = 0; i < n1.length; i++) {
                newresult[i + 1] = n1[i];
            }
            return newresult;
        }
    }
    public static void main(String[] args){

        if (args.length != 2){
            System.err.println("ERROR: Introduzca 2 parametros");
            System.exit(1);
        }

        In in1 = new In(args[0]);
        int[] num1 = in1.readAllInts();
        formato(num1, args[0]);

        In in2 = new In(args[1]);
        int[] num2 = in2.readAllInts();
        formato(num2, args[1]);

        int[] solucion = suma(num1, num2);

        StdOut.println(Arrays.toString(solucion));
    }
}
