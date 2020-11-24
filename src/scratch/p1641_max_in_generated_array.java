package scratch;

public class p1641_max_in_generated_array {
    public static void main(String[] args) {
        p1641_max_in_generated_array p = new p1641_max_in_generated_array();
        int n = 7;  // 3
        // int n = 2;  // 1
        // int n = 3;  // 2
        System.out.println(p.getMaximumGenerated(n));
    }

    public int getMaximumGenerated(int n) {
        if (n <= 1) { return n; }
        int len = n+1, res = 1;
        int[] nums = new int[n+1];
        nums[0] = 0; nums[1] = 1;
        for(int i = 1; i <= n/2; i++) {
            int e = 2 * i;
            if (e <= n) {
                nums[e] = nums[i];
                res = Math.max(res, nums[e]);
            }
            int o = 2 * i + 1;
            if (o <= n) {
                nums[o] = nums[i] + nums[i + 1];
                res = Math.max(res, nums[o]);
            }
        }
        // System.out.println(ArrayUtils.dumpArray(nums));
        return res;
    }
}
