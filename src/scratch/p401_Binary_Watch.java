package scratch;

import java.util.*;

public class p401_Binary_Watch {
    public static void main(String[] args) {
        p401_Binary_Watch p = new p401_Binary_Watch();
        int num = 1;
        System.out.println(p.readBinaryWatch(num));

    }
    public List<String> readBinaryWatch(int num) {
        Set<String> res = new HashSet<>();
        for(int n = 0; n <= num; n++) {
            Set<Integer> hours = helper(new int[]{8,4,2,1}, n);
            Set<Integer> mins = helper(new int[]{32,16,8,4,2,1}, num - n);
            for(int h : hours) {
                if (h >= 12) { continue; }
                for (int m : mins) {
                    if (m >= 60) { continue; }
                    res.add(String.format("%d:%02d", h, m));
                }
            }
        }
        List ret = new ArrayList();
        ret.addAll(res);
        return ret;
    }

    private Set<Integer> helper(int[] digs,  int num) {
        Set<Integer> res = new HashSet<>();
        dfs(digs, 0, num, 0, res);
        return res;
    }

    private void dfs(int[] digs, int cur, int num, int val, Set<Integer> res) {
        int len = digs.length;
        if (len-cur < num) { return; }
        if (num == 0) {
            res.add(val);
            return;
        }
        for(int i = cur; i < len; i++) {
            dfs(digs, i+1, num-1, val + digs[i], res);
        }
    }
}
