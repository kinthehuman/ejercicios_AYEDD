package ayedd.e3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Int {

    private int[] a;

    public Int(int i) {

        int neg = 0;
        if (i < 0) {
            i = -i;
            neg = 1;
        }
        int n = i;
        int grado = 1;
        while (n >= 10) {
            n = n / 10;
            grado++;
        }
        a = new int[grado];
        for (int l = 1; l <= a.length; l++) {
            if (i > 0) {
                a[a.length - l] = ( i % 10 );
                i = i / 10;
            }
        }
        if (neg == 1) this.minus();
    }



    public Int(Int i) {
        a = i.a;
    }



    public Int(String s) {
        if (s.charAt(0) == '-') {
            a = new int[s.length() - 1];
            for (int l = 0; l < a.length; l++) {
                a[l] = Character.getNumericValue(s.charAt(l + 1));
            }
            this.minus();
        } else {
            a = new int[s.length()];
            for (int l = 0; l < a.length; l++) {
                a[l] = Character.getNumericValue(s.charAt(l));
            }
        }
    }



    private static int[] suma(int[] n1, int[] n2){
        int dif = n1.length - n2.length;
        int acarreo = 0;
        if (dif > 0) {
            int[] result = new int[n1.length];
            for (int i = 1; i <= n2.length; i++) {
                result[result.length - i] = (n2[n2.length - i] + n1[n1.length - i] + acarreo) % 10;
                acarreo = (n2[n2.length - i] + n1[n1.length - i] + acarreo) / 10;
            }
            for (int i = dif - 1; i >= 0; i--){
                result[i] = (n1[i] + acarreo) % 10;
                acarreo = (n1[i] + acarreo) / 10;
                if (acarreo == 0)  {return result;}
            }
            int[] newresult = new int[result.length + 1];
            newresult[0] = acarreo;
            for (int i = 0; i < result.length; i++) {
                newresult[i + 1] = result[i];
            }
            return newresult;
        }
        else if (dif < 0){
            int[] result = new int[n2.length];
            for (int i = 1; i <= n1.length; i++) {
                result[result.length - i] = (n2[n2.length - i] + n1[n1.length - i] + acarreo) % 10;
                acarreo = (n2[n2.length - i] + n1[n1.length - i] + acarreo) / 10;
            }
            for (int i = - dif - 1; i >= 0; i--){
                result[i] = (n2[i] + acarreo) % 10;
                acarreo = (n2[i] + acarreo) / 10;
                if (acarreo == 0) return result;
            }
            int[] newresult = new int[result.length + 1];
            newresult[0] = acarreo;
            for (int i = 0; i < result.length; i++) {
                newresult[i + 1] = result[i];
            }
            return newresult;
        }
        else {
            int[] result = new int[n1.length];
            for (int i = n1.length - 1; i >= 0; i--) {
                result[i] = (n2[i] + n1[i] + acarreo) % 10;
                acarreo = (n2[i] + n1[i] + acarreo) / 10;
            }
            if (acarreo == 0)  {return result;}
            int[] newresult = new int[result.length + 1];
            newresult[0] = acarreo;
            for (int i = 0; i < result.length; i++) {
                newresult[i + 1] = result[i];
            }
            return newresult;
        }
    }

    private int[] resta (int[] n1, int[] n2){
        int dif = n1.length - n2.length;
        int acarreo = 0;
        int[] result;
        if (dif > 0) {
            result = new int[n1.length];
            for (int i = 1; i <= n2.length; i++) {
                result[result.length - i] = (n1[n1.length - i] - n2[n2.length - i] + acarreo);
                acarreo = 0;
                if (result[result.length - i] < 0) {
                    result[result.length - i] = 10 + result[result.length - i];
                    acarreo = -1;
                }
            }
            for (int i = dif - 1; i >= 0; i--){
                result[i] = (n1[i] + acarreo);
                if (i != 0 && result[i] < 0) {
                    result[i] = 10 + result[i];
                    acarreo = -1;
                }
            }
        }
        else if (dif < 0){
            result = new int[n2.length];
            for (int i = 1; i <= n1.length; i++) {
                result[result.length - i] = (n1[n1.length - i] - n2[n2.length - i] + acarreo);
                acarreo = 0;
                if (result[result.length - i] < 0) {
                    result[result.length - i] = 10 + result[result.length - i];
                    acarreo = -1;
                }
            }
            for (int i = - dif - 1; i >= 0; i--){
                result[i] = (result[i] + acarreo) % 10;
                if (i != 0 && result[i] < 0) {
                    result[i] = 10 + result[i];
                    acarreo = -1;
                }
            }
        }
        else {
            result = new int[n1.length];
            for (int i = n1.length - 1; i >= 0; i--) {
                result[i] = (n1[i] - n2[i] + acarreo);
                acarreo = 0;
                if ( i != 0 && result[i] < 0) {
                    result[i] = 10 + result[i];
                    acarreo = -1;
                }
            }
        }
        while (result[0] == 0 && result.length > 1){
            int[] newresult = new int[result.length - 1];
            for (int i = 1; i < result.length; i++){
                newresult[i - 1] = result[i];
            }
            result = newresult;
        }
        return result;
    }

    public void plus (Int that){
        if ( this.a[0] >= 0 && that.a[0] >= 0 ){
            this.a = suma(this.a, that.a);
        }
        else if ( this.a[0] < 0 && that.a[0] < 0 ) {
            this.minus();
            that.minus();
            this.a = suma(this.a, that.a);
            this.minus();
            that.minus();
        }
        else if ( this.a[0] >= 0 ){
            that.minus();
            this.a = resta(this.a, that.a);
            that.minus();
        }
        else{
            this.minus();
            this.a = resta(this.a, that.a);
            this.minus();
        }
    }

    public void minus() {
        this.a[0] = -this.a[0];
    }

    public boolean equals (Object that){
        if (this == that) return true;
        if (that == null) return false;
        if (this.getClass() != that.getClass()) { return false; }
        Int x = (Int) that;
        if (this.a != x.a)   { return false; }
        return true;
    }

    public String toString() {
        if (a[0] < 0) {
            this.minus();
            char[] r = new char[this.a.length + 1];
            r[0] = '-';
            for (int l = 0; l < this.a.length; l++) {
                r[ l + 1 ] = (char)(a[l] + '0');
            }
            this.minus();
            return new String(r);
        }
        else{
            char[] r = new char[a.length];
            for (int l = 0; l < a.length; l++) {
                r[ l ] = (char)(a[l] + '0');
            }
            return new String(r);
        }
    }
}
