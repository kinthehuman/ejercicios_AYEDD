package ayedd.examenFinal;
import edu.princeton.cs.algs4.*;

public class Shuffle<Item> {

    private Queue<Item> q;

    public Shuffle(){
        q = new Queue<>();
    }

    public void add(Item item){
        q.enqueue(item);
    }

    public void shuffle(int n) {
        int shuffles = 0;
        int size = q.size();
        int half;
        if (size % 2 == 0) {half = size / 2;}
        else {half = size / 2 + 1;}
        //int[] h1 = new int[half];
        //int[] h2 = new int[size - half];
        Queue<Item> h1 = new Queue<>();
        Queue<Item> h2 = new Queue<>();

        while (shuffles < n){
            for (int i = 0; i < half; i++) {
                h1.enqueue(q.dequeue());
            }
            for (int i = half; i < size; i++) {
                h2.enqueue(q.dequeue());
            }
            while (!h1.isEmpty()) {
                q.enqueue(h1.dequeue());
                if (!h2.isEmpty()){q.enqueue(h2.dequeue());}
            }
            shuffles++;
        }
    }

    public String toString(){
        String output = "[ ";
        for (Item i:this.q) {
            output = output + i + " ";
        }
        output = output + "]";
        return output;
    }

    public static void main(String[] args){
        Shuffle<Integer> a = new Shuffle<Integer>();
        for (int i = 0; i <= 4; i++){
            a.add(i);
        }
        System.out.println(a.toString());
        a.shuffle(0);
        System.out.println(a.toString());
    }
}
