package collections;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;

public class Queues {
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        Queue<Integer> q3 = new PriorityQueue<>();
        Queue<Integer> q4 = new ConcurrentLinkedQueue<>();
        Queue<Integer> q5 = new ConcurrentLinkedDeque<>();
        Queue<Integer> q6 = new ArrayBlockingQueue<Integer>(20); // can be only assigned to Queue, rest can be assigned to Dequeue
        Queue<Integer> q7 = new LinkedBlockingQueue<>();
        Queue<Integer> q8 = new LinkedBlockingDeque<>();
        Queue<Integer> q9 = new LinkedTransferQueue<>();
        Queue<Integer> q10 = new PriorityBlockingQueue<>();
        Queue<Integer> q11 = new SynchronousQueue<>();
    }
}
