package scratch.p000;

import common.ArrayUtils;

import java.util.Arrays;

public class p31_Next_Permutation {
    public static void main(String[] args) {
        p31_Next_Permutation p = new p31_Next_Permutation();

        // int[] nums = {1,2,3};
        // int[] nums = {3,2,1};
        int[] nums = {1,1,5};
        System.out.println(ArrayUtils.dumpArray(nums));

        p.nextPermutation(nums);
        System.out.println(ArrayUtils.dumpArray(nums));
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) { return; }

        int len = nums.length;
        int i = len-1;
        while(i > 0) {
            if (nums[i-1] < nums[i]) {
                break;
            }
            i--;
        }

        if (i == 0) {
            Arrays.sort(nums, 0, len);
            return;
        }

        // nums[i] > nums[i-1]

        int left = i-1, right = i;
        int j = i;
        for(j = i; j < len; j++) {
            if (nums[left] >= nums[j]) {
                break;
            }
            right = j;
        }

        int k = nums[left];
        nums[left] = nums[right];
        nums[right] = k;

        Arrays.sort(nums, left+1, len);
    }
}
