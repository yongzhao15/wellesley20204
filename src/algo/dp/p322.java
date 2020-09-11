package algo.dp;

import common.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

public class p322 {
    public static void main(String[] args) {
        p322 p = new p322();
        int[] coins = new int[] {1,2,5};
        int amount = 11;
//        int[] coins = new int[] {2};
//        int amount = 3;

        System.out.println(p.coinChange(coins, amount));


    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) { return 0; }
        return dp(coins, amount);
//        mem = new HashMap<>();
//        return dfs(coins, amount);

    }

    private int dp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; i++) {
            dp[i] = -1;
            for(int c : coins) {
                if (i - c >= 0 && dp[i-c] >= 0) {
                    dp[i] = dp[i] < 0 ? 1 + dp[i-c] : Math.min(dp[i], 1 + dp[i-c]);
                }
            }
        }

        // System.out.println(ArrayUtils.dumpArray(dp));
        return dp[amount];
    }

    Map<Integer, Integer> mem;
    private int dfs(int[] coins, int amount) {
        if (mem.containsKey(amount)) {
            return mem.get(amount);
        }

        int res = -1;
        for(int c : coins) {
            if (c > amount ) { continue; }
            if (c == amount) { res = 1; break; }

            // c < amount
            int res2 = dfs(coins, amount - c);
            if (res2 > 0) {
                res = res < 0 ? 1 + res2 : Math.min(res, 1 + res2);
            }
        }

        mem.put(amount, res);
        return res;
    }
}
