package ayedd.e5;
import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> implements Iterable<Item>
{
    private Node first;  // enlace al elemento más antiguo en la cola
    private Node last;   // enlace al elemento más nuevo en la cola
    private int n = 0;   // número de ítems en la cola

    private class Node
    {   //  clase anidada para definir nodos
        Item item;
        Node next;
    }

    public boolean isEmpty() {  return first == null;  }
    public int size()        {  return n;              }

    public void enqueue(Item item)
    {   // Añadir item al final de la lista
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())  {  first = last;         }
        else            {  oldlast.next = last;  }
        n++;
    }
    public Item dequeue()
    {   // eliminar item del comienzo de la lista
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) { last = null; }
        return item;
    }

    public Iterator<Item> iterator()
    {  return new ListIterator();  }
    private class ListIterator implements Iterator<Item>
    {
	private Node current = first;
	public boolean hasNext() {  return current != null;  }
	public void remove() { }
	public Item next()
	{
	    Item item = current.item;
	    current = current.next;
	    return item;
	}
    }

    public static void main (String[] args)
    {
        Queue<String> q = new Queue<String>();

        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            if (!item.equals("-")) { q.enqueue(item); }
            else if (!q.isEmpty()) { StdOut.print(q.dequeue() + " "); }
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }    

    
}
