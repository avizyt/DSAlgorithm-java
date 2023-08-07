package priorityQueue;

import java.util.ArrayList;
import java.util.List;
public class PriorityQueue {
    private final List<Integer> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    public void insert(int data){
        heap.add(data);
        siftUp(heap.size() - 1);
    }

    public int extractMin() {
        if (isEmpty()){
            throw new IllegalStateException("Priority queue is empty.");
        }

        int min = heap.get(0);
        int lastIdx = heap.size() - 1;
        heap.set(0, heap.get(lastIdx));
        heap.remove(lastIdx);
        siftDown(0);
        return min;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void siftUp(int index){
        int parentIdx = (index - 1 )/2;
        while (index > 0 && heap.get(index) < heap.get(parentIdx)){
            swap(index, parentIdx);
            index = parentIdx;
            parentIdx = (index - 1)/2;
        }
    }

    private void siftDown(int index){
        int leftChildIdx = 2 * index + 1;
        int rightChildIdx = 2 * index + 2;
        int smallest = index;

        if (leftChildIdx < heap.size() && heap.get(leftChildIdx) < heap.get(smallest)) {
            smallest = leftChildIdx;
        }

        if (rightChildIdx < heap.size() && heap.get(rightChildIdx) < heap.get(smallest)) {
            smallest = rightChildIdx;
        }

        if (smallest != index) {
            swap(index, smallest);
            siftDown(smallest);
        }
    }
    private void swap(int i, int j){
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void display(){
        for (int val: heap){
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();

        // Insert elements into the priority queue
        pq.insert(5);
        pq.insert(10);
        pq.insert(2);
        pq.insert(8);
        pq.insert(1);

        // Display the contents of the priority queue
        System.out.println("Priority Queue: ");
        pq.display();

        // Extract elements in priority order and display them
        System.out.println("Extracted elements in priority order: ");
        while (!pq.isEmpty()) {
            int min = pq.extractMin();
            System.out.print(min + " ");
        }
        System.out.println();
    }
}
