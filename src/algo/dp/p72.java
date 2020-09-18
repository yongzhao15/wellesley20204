package algo.dp;

import common.ArrayUtils;

public class p72 {
    public static void main(String[] args) {
        // String word1 = "horse", word2 = "ros";
        // String word1 = "intention", word2 = "execution";
        String word1 = "ab", word2 = "bc";
        p72 p = new p72();
        System.out.println(p.minDistance(word1, word2));

    }

    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) { return 0; }
        if (word1 == null || word1.length() == 0) { return word2.length(); }
        if (word2 == null || word2.length() == 0) { return word1.length(); }

        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m][n];
        dp[0][0] = word1.charAt(0) == word2.charAt(0)? 0 : 1;
        for(int j = 1; j < n; j++) {
            dp[0][j] = word1.charAt(0) == word2.charAt(j)? Math.min(dp[0][j-1] + 1, j) : dp[0][j-1] + 1;
        }
        for(int i = 1; i < m; i++) {
            dp[i][0] = word1.charAt(i) == word2.charAt(0) ? Math.min(dp[i-1][0] + 1, i) : dp[i-1][0] + 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1] + 1, Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
                }
            }
        }

        // System.out.println(ArrayUtils.dumpArray2D(dp));

        return dp[m-1][n-1];
    }
}
