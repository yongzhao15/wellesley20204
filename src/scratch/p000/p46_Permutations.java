package scratch.p000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p46_Permutations {
    public static void main(String[] args) {
        p46_Permutations p = new p46_Permutations();
        int[] nums = {1,2,3};
        // int[] nums = {0, 1};
        System.out.println(p.permute(nums));

    }

    public List<List<Integer>> permute(int[] nums) {
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
            swap(nums, cur, i);
            dfs(nums, cur+1, res);
            swap(nums, cur, i);
        }
    }

    private void swap(Integer[] nums, int i , int j) {
        if (i == j) { return; }

        Integer m = nums[i];
        nums[i] = nums[j];
        nums[j] = m;
    }
}
