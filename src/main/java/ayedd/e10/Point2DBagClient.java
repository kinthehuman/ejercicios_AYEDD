package ayedd.e10;
import edu.princeton.cs.algs4.*;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

public class Point2DBagClient {


    public static void main(String[] args){
        In doc = new In(args[0]);
        double[] coordinates = doc.readAllDoubles();
        Point2DBag points = new Point2DBag();
        double min = 0.0;
        double max = 1.0;

        for (int i = 0; i < coordinates.length - 1; i = i + 2){
            double x = coordinates[i];
            double y = coordinates[i + 1];
            if (min <= x && x <= max && min <= y && y <= max){
                Point2D a = new Point2D(x, y);
                points.add(a);
            }
            else{
                System.err.println("Las coordenadas deben estar entre 0.0 y 1.0");
                System.exit(1);
            }

        }

        double x = Double.parseDouble(args[1]);
        double y = Double.parseDouble(args[2]);

        if (!(min <= x && x <= max && min <= y && y <= max)){
            System.err.println("Las coordenadas deben estar entre 0.0 y 1.0");
            System.exit(1);
        }

        Point2D p = new Point2D(x, y);

        if (args[3].equals("A") && !points.isEmpty()){
            points.sort(p, p.adistanceToOrder());
        }
        else if (args[3].equals("D") && !points.isEmpty()){
            points.sort(p, p.ddistanceToOrder());
        }
        else {
            System.err.println("Introduzca criterio de ordenacion: A o D");
            System.exit(1);
        }


        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.0005);
        p.draw();

        for (Point2D a : points) {
            a.draw();
            StdOut.println(a.toString());
            p.drawTo(a);
        }
    }

}
