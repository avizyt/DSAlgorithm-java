package fundamentals;

import edu.princeton.cs.algs4.Queue;

public class QClient {
    public static void main(String[] args) {
        String[] item = {"a", "ab", "bcd", "efgh"};
        Queue<String> queue = new Queue<>();
        for (String x: item){
            queue.enqueue(x);
        }
        System.out.println(queue);

    }
}
