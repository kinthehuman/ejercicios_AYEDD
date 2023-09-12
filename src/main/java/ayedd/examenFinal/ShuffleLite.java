package ayedd.examenFinal;


public class ShuffleLite<Item> {
    private class Node{
        Item item;
        Node next;
    }

    private Node first;
    private Node last;
    private int x;

    public ShuffleLite(){
        first = null;
        last = null;
        x = 0;
    }

    public void add(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (first == null){first = last;}
        else{oldlast.next = last;}
        this.x++;
    }

    public void shuffle(int n) {
        int shuffles = 0;
        int half;
        int size = this.x;
        if (size % 2 == 0) {half = size / 2;}
        else {half = size / 2 + 1;}
        ShuffleLite<Item> h1 = new ShuffleLite();
        ShuffleLite<Item> h2 = new ShuffleLite();

        while (shuffles < n && size > 0){
            for (int i = 0; i < half; i++) {
                Item item = this.first.item;
                this.first = this.first.next;
                this.x--;
                if (this.first == null) { this.last = null; }
                h1.add(item);
            }

            for (int i = half; i < size; i++) {
                Item item = this.first.item;
                this.first = this.first.next;
                this.x--;
                if (this.first == null) { this.last = null; }
                h2.add(item);
            }
            //System.out.println("h1 = " +  h1.toString() + "  h2 = " + h2.toString());
            while (h1.first != null) {
                Item item = h1.first.item;
                h1.first = h1.first.next;
                h1.x--;
                if (h1.first == null) { h1.last = null; }
                this.add(item);
                if (h2.first != null){
                    item = h2.first.item;
                    h2.first = h2.first.next;
                    h2.x--;
                    if (h2.first == null) { h2.last = null; }
                    this.add(item);
                }
            }
            shuffles++;
        }
    }

    public String toString(){
        String output = "[ ";
        Node current = this.first;
        output = output + current.item + " ";
        while (current.next != null){
            current = current.next;
            output = output + current.item + " ";
        }
        output = output + "]";
        return output;
    }

    public static void main(String[] args){
        ShuffleLite<Integer> a = new ShuffleLite<Integer>();
        for (int i = 0; i <= 4; i++){
            a.add(i);
        }
        System.out.println(a.toString());
        a.shuffle(2);
        System.out.println(a.toString());
    }
}
