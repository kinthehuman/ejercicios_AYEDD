package ayedd.e5;

import java.util.Iterator;

public class FactorialFactory {

    private boolean mem;
    private FactorialSet a;

    FactorialFactory(boolean isMemo){

        mem = isMemo;

        if (isMemo){
            a = new FactorialSet();
        }

    }
    Int factorial(Int n){
        if (!mem) {
            Int i = new Int(-1);
            n.plus(i);
            i.minus();
            Iterator<Int> iterator = factorial(i, n);
            while (iterator.hasNext()) {
                iterator.next();
            }
            return iterator.next();
        }
        else{

        }
    }

    Iterator<Int> factorial(Int m, Int n){

        if (!mem) {

            Queue<Int> cola = new Queue<Int>();
            Int result = new Int(1);
            Int i = new Int(1);
            Int sign = new Int(m);
            n.minus();
            sign.plus(n);
            n.minus();
            if (sign.positive()) {
                Int current = new Int(m);
                while (!current.equals(n)) {
                    current.plus(i);
                    result.multiply(current);
                    cola.enqueue(result);
                }
                return cola.iterator();
            } else {
                Int current = new Int(n);
                while (!current.equals(m)) {
                    current.plus(i);
                    result.multiply(current);
                    cola.enqueue(result);
                }
                return cola.iterator();
            }


        }
        else{

        }


    }
}
