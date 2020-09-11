package algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class p39 {
    public static void main(String[] args) {
        p39 p = new p39();
//        int[] candidates = new int[] {2,3,5};
//        int target = 8;
        int[] candidates = new int[] {2,3,6,7};
        int target = 7;
        System.out.println(p.combinationSum(candidates, target));

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(target, candidates, 0, cur, res);
        return res;
    }

    private void dfs(int tar, int[] candidates, int pos, List<Integer> cur, List<List<Integer>> res) {
        if (tar < 0) {
            return;
        }
        if (tar == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = pos; i < candidates.length; i++) {
            cur.add(candidates[i]);
            dfs(tar - candidates[i], candidates, i, cur, res);
            cur.remove(cur.size()-1);
        }
    }
}
