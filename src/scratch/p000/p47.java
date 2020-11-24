package scratch.p000;

import java.util.*;

public class p47 {
    public static void main(String[] args) {
        p47 p = new p47();
        // int[] nums = {1,2,3};
        int[] nums = {1,2,1};
        // int[] nums = {0, 1};
        System.out.println(p.permuteUnique(nums));

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) { return res; }

        int len = nums.length;
        Integer[] arr = new Integer[len];
        for(int i = 0; i < len; i++) {
            arr[i] = nums[i];
        }

        dfs(arr, 0, res);
        return res;
    }

    private void dfs(Integer[] nums, int cur, List<List<Integer>> res) {
        if (cur == nums.length) {
            List<Integer> p = new ArrayList<Integer>(Arrays.asList(nums));
            res.add(p);
            return;
        }

        for(int i = cur; i < nums.length; i++) {
            if (nums[cur].intValue() != nums[i].intValue()) {
                swap(nums, cur, i);
                dfs(nums, cur + 1, res);
                swap(nums, cur, i);
            }
        }
    }

    private void swap(Integer[] nums, int i , int j) {
        if (i == j) { return; }

        Integer m = nums[i];
        nums[i] = nums[j];
        nums[j] = m;
    }
}
