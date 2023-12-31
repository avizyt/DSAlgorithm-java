package stack;

public class FixedCapacityStack<Item> {
    private Item[] a;
    private int N;

    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
            a = temp;
        }
    }

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }

    public void push(Item item) {
        if (N == a.length) {
            resize(2*a.length);
        }
        a[N++] = item;
    }

    public String pop() {
        String item = (String)a[--N];
        a[N] = null;
        if (N>0 && N == a.length/4) {
            resize(a.length/2);
        }
        return item;
    }

}
