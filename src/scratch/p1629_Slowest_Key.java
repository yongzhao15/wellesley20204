package scratch;

import java.util.Comparator;
import java.util.PriorityQueue;

public class p1629_Slowest_Key {
    public static void main(String[] args) {
//        int[] releaseTimes = new int[] {12,23,36,46,62};
//        String keysPressed = "spuda";
        int[] releaseTimes = new int[] {9,29,49,50};
        String keysPressed = "cbcd";
        p1629_Slowest_Key p = new p1629_Slowest_Key();
        System.out.println(p.slowestKey(releaseTimes, keysPressed));
    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        // time, char
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return -1 * Integer.compare(o1[0], o2[0]);
                } else {
                    return -1 * Character.compare(keysPressed.charAt(o1[1]), keysPressed.charAt(o2[1]));
                }
            }
        });

        int len = releaseTimes.length;
        maxHeap.offer(new int[]{releaseTimes[0], 0});
        for(int i = 1; i < len; i++) {
            maxHeap.offer(new int[]{releaseTimes[i] - releaseTimes[i-1], i});
        }

        int[] res = maxHeap.poll();
        return keysPressed.charAt(res[1]);
    }
}
