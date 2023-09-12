package ayedd.e10;
import edu.princeton.cs.algs4.*;
import java.util.Comparator;
import java.util.Iterator;

public class Point2DBag implements Iterable<Point2D>
{
    private Node first; // primer nodo de la lista
    private int n;
    private class Node
    {   // clase anidada privada para definir nodos
	Point2D point;
	Node next;
    }
    public boolean isEmpty() {  return first == null; }
    public int size()        {  return n;             }
    public void add(Point2D point)
    {   // Añadir point a la bolsa: igual que push() de la pila
	Node oldfirst = first;
	first = new Node();
	first.point = point;
	first.next = oldfirst;
	n++;
    }

    public Iterator<Point2D> iterator()
    {  return new ListIterator();  }

    private class ListIterator implements Iterator<Point2D>
    {
	private Node current = first;

	public boolean hasNext() {  return current != null;  }
	public void remove() { }
	public Point2D next()
	{
	    Point2D point = current.point;
	    current = current.next;
	    return point;
	}
    }


    public void sort(Point2D p, Comparator comparator)
    {
	// ...
    Node low = first;
    Node mid = first;
    Node high = first;

    while (high.next != null){
        while (mid.next != null && comparator.compare(mid.point, mid.next.point) <= 0){
            mid = mid.next;
        }
        if (mid.next != null){
            high = mid.next;
            while (high.next != null && comparator.compare(high.point, high.next.point) <= 0){
                high = high.next;
            }
            //StdOut.println("merging: low = " + low.point.toString() + " mid = " + mid.point.toString() + " mid.next = " + mid.next.point.toString() + " high = " + high.point.toString());
            Node i = low;
            Node j = mid;
            while (true) {
                boolean inc = false;
                boolean b = false;
                if (i == high || j == high) {
                    //StdOut.println("merge done.");
                    break;}
                if (i == first) {
                    //StdOut.println("comparing: i(first) = " + i.point.toString() + " j.next = " + j.next.point.toString());
                    if (comparator.compare(i.point, j.next.point) > 0) {
                        //StdOut.println("swapping1:" + j.next.point.toString() + " goes before " + i.point.toString());
                        Node old = j.next;
                        if (j.next == high) {high = j; b = true;}
                        j.next = j.next.next;
                        //StdOut.println("j.next increment1");
                        inc = true;
                        old.next = i;
                        first = old;
                        i = old;
                    }
                    else {
                        //StdOut.println("comparing: i(first).next = " + i.next.point.toString() + " j.next = " + j.next.point.toString());
                        if (comparator.compare(i.next.point, j.next.point) > 0) {
                            //StdOut.println("swapping2:" + j.next.point.toString() + " goes between " + i.point.toString() + " and " + i.next.point.toString());
                            Node old = j.next;
                            if (j.next == high) {
                                high = j;
                                b = true;
                            }
                            j.next = j.next.next;
                            //StdOut.println("j.next increment");
                            old.next = i.next;
                            i.next = old;
                            i = old;
                            inc = true;
                        }
                    }
                }
                else {
                    //StdOut.println("comparing: i.next = " + i.next.point.toString() + " j.next = " + j.next.point.toString());
                    if (comparator.compare(i.next.point, j.next.point) > 0) {
                        //StdOut.println("swapping2:" + j.next.point.toString() + " goes between " + i.point.toString() + " and " + i.next.point.toString());
                        Node old = j.next;
                        if (j.next == high) {
                            high = j;
                            b = true;
                        }
                        j.next = j.next.next;
                        //StdOut.println("j.next increment");
                        inc = true;
                        old.next = i.next;
                        i.next = old;
                        i = i.next;
                    }
                }
                if (!inc) {i = i.next; //StdOut.println("i increment");
                break;
                    }
                if (b){break;}
                }
            }
        low = first;
        mid = high;
        }
    }
}    
