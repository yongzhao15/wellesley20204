package challenges.week_2020_10_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3479/
public class Maximum_Distance_in_Arrays {
    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<>();
//        arrays.add(Arrays.asList(new Integer[] {1,2,3}));
//        arrays.add(Arrays.asList(new Integer[] {4,5}));
//        arrays.add(Arrays.asList(new Integer[] {1,2,3}));
        arrays.add(Arrays.asList(new Integer[] {-6,-3,-1,1,2,2,2}));
        arrays.add(Arrays.asList(new Integer[] {-10,-8,-6,-2,4}));
        arrays.add(Arrays.asList(new Integer[] {-2}));
        arrays.add(Arrays.asList(new Integer[] {-8,-4,-3,-3,-2,-1,1,2,3}));
        arrays.add(Arrays.asList(new Integer[] {-8,-6,-5,-4,-2,-2,2,4}));

        Maximum_Distance_in_Arrays p = new Maximum_Distance_in_Arrays();
        System.out.println(p.maxDistance(arrays));

    }

    public int maxDistance(List<List<Integer>> arrays) {
        int res = 0;
        PriorityQueue<List<Integer>> maxHeapForMins = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return -1 * Integer.compare(o1.get(0), o2.get(0));
            }
        });

        PriorityQueue <List<Integer>> minHeapForMaxs = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return Integer.compare(o1.get(o1.size()-1), o2.get(o2.size()-1));
            }
        });

        int len = arrays.size();
        for(int l = 0; l < len; l++) {
            updateMaxHeapForMins(arrays, l, maxHeapForMins);
            updateMinHeapForMaxs(arrays, l, minHeapForMaxs);
        }

        res = calcMaxDistance(maxHeapForMins, minHeapForMaxs);
        return res;
    }

    private void updateMaxHeapForMins(List<List<Integer>> arrays, int l, PriorityQueue<List<Integer>> maxHeapForMins) {
        if (maxHeapForMins.size() < 2) {
            maxHeapForMins.add(arrays.get(l));
        } else {
            if (arrays.get(l).get(0) < maxHeapForMins.peek().get(0)) {
                maxHeapForMins.poll();
                maxHeapForMins.add(arrays.get(l));
            }
        }
    }

    private void updateMinHeapForMaxs(List<List<Integer>> arrays, int l, PriorityQueue<List<Integer>> minHeapForMaxs) {
        if (minHeapForMaxs.size() < 2) {
            minHeapForMaxs.add(arrays.get(l));
        } else {
            if (arrays.get(l).get(arrays.get(l).size()-1) > minHeapForMaxs.peek().get(minHeapForMaxs.peek().size()-1)) {
                minHeapForMaxs.poll();
                minHeapForMaxs.add(arrays.get(l));
            }
        }
    }

    private int calcMaxDistance(PriorityQueue<List<Integer>> maxHeapForMins, PriorityQueue<List<Integer>> minHeapForMaxs) {
        List<Integer> min2 = maxHeapForMins.poll(), min1 = maxHeapForMins.poll();
        System.out.println(min1);
        System.out.println(min2);

        List<Integer> max2 = minHeapForMaxs.poll(), max1 = minHeapForMaxs.peek();
        System.out.println(max1);
        System.out.println(max2);

        if (!min1.equals(max1)) {
            return Math.abs(min1.get(0) - max1.get(max1.size()-1));
        } else {
            return Math.max(Math.abs(min1.get(0) - max2.get(max2.size()-1)), Math.abs(min2.get(0) - max1.get(max1.size()-1)));
        }
    }
}
