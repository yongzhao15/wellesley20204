package misc;

import common.ArrayUtils;

import java.util.*;

public class p1630_Arithmetic_Subarrays {
    public static void main(String[] args) {
        p1630_Arithmetic_Subarrays p = new p1630_Arithmetic_Subarrays();

//        int[] nums = {4,6,5,9,3,7};
//        int[] l = {0,0,2};
//        int[] r = {2,3,5};
        int[] nums = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
        int[] l = {0,1,6,4,8,7};
        int[] r = {4,4,9,7,9,10};

        System.out.println(p.checkArithmeticSubarrays(nums,l,r));

    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int len = nums.length;
        Integer[] sorted = new Integer[len];
        for(int i = 0; i < len; i++) {
            sorted[i] = i;
        }
        Arrays.sort(sorted, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(nums[o1], nums[o2]);
            }
        });

        int qLen = l.length;
        List<Boolean> res = new ArrayList<>();
        for(int i = 0; i < qLen; i++) {
            res.add(isArithmeticSubarrays(nums, sorted, l[i], r[i]));
        }

        return res;
    }

    private boolean isArithmeticSubarrays(int[] nums, Integer[] sorted, int left, int right) {
        if (right - left <= 1) {
            return true;
        }

        List<Integer> sub = new ArrayList<>();
        for(int i = 0; i < sorted.length; i++) {
            if (left <= sorted[i] && sorted[i] <= right) {
                sub.add(nums[sorted[i]]);
            }
        }
        // System.out.println(sub);

        int diff = sub.get(1) - sub.get(0);
        for(int i = 2; i < sub.size(); i++) {
            if (sub.get(i) - sub.get(i-1) != diff) {
                return false;
            }
        }

        return true;
    }
}
