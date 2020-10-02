package challenges.week_2020_10_01;

import java.util.PriorityQueue;

public class RecentCounter {
    PriorityQueue<Integer> minHeap;
    public RecentCounter() {
        minHeap = new PriorityQueue<>();
    }

    public int ping(int t) {
        while(!minHeap.isEmpty() && minHeap.peek() < (t-3000)) {
            minHeap.poll();
        }
        minHeap.add(t);
        return minHeap.size();
    }
}
