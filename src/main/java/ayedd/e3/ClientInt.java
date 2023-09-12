package ayedd.e3;
import edu.princeton.cs.algs4.*;

import java.util.Arrays;

public class ClientInt {

    public static void main(String[] args){

        if (args.length == 3){

            for (int i = 0; i < args[0].length(); i++) {
                if (!(Character.isDigit(args[0].charAt(i)))) {
                    if (!(i == 0) && !(args[0].charAt(i) == '-')) {
                        System.err.println("Usage: El argumento 1 no es entero");
                        System.exit(1);
                    }
                }
            }
            for (int i = 0; i < args[2].length(); i++) {
                if (!(Character.isDigit(args[2].charAt(i)))) {
                    if (!(i == 0) && !(args[2].charAt(i) == '-')) {
                        System.err.println("Usage: El argumento 3 no es entero");
                        System.exit(1);
                    }
                }
            }

            Int n1 = new Int(args[0]);
            Int n2 = new Int(args[2]);
            if (args[1].equals("+")){
                n1.plus(n2);
                StdOut.println(n1.toString());
            }
            else if (args[1].equals("-")){
                n2.minus();
                n1.plus(n2);
                StdOut.println(n1.toString());
            }
            else {
                System.err.println("Usage: El argumento 2 no es un operador");
                System.exit(1);
            }

        }
        else {
            System.err.println("Usage: No hay 3 argumentos");
            System.exit(1);
        }
    }
}

