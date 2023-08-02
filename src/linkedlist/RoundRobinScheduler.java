package linkedlist;

public class RoundRobinScheduler {
    public static void main(String[] args) {
        CircularLinkedList processQueue = new CircularLinkedList();
        for (int i = 1; i <= 10 ; i++) {
            processQueue.add(i);
        }

        int timeSlice = 2;

        // Round-robin scheduling
        int remainingTime;
        while (processQueue.getSize() > 0){
            CircularLinkedList.Node currentProcess = processQueue.head;
            remainingTime = timeSlice;

            while (remainingTime >= 0){
                System.out.print(currentProcess.data + " ");
                remainingTime--;
            }

            processQueue.head = currentProcess.next;

            if (remainingTime > 0){
                processQueue.add(currentProcess.data);
            }else {
                processQueue.removeHead();
            }

            processQueue.getSize();
            processQueue.display();
        }
    }
}
