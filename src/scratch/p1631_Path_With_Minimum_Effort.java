package scratch;

import java.util.HashSet;
import java.util.Set;

public class p1631_Path_With_Minimum_Effort {
    public static void main(String[] args) {
        p1631_Path_With_Minimum_Effort p = new p1631_Path_With_Minimum_Effort();

        // int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        // int[][] heights = {{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
        // int[][] heights = {{4,3,4,10,5,5,9,2},{10,8,2,10,9,7,5,6},{5,8,10,10,10,7,4,2},{5,1,3,1,1,3,1,9},{6,4,10,6,10,9,4,6}};
        int[][] heights = {{8,3,2,5,2,10,7,1,8,9},{1,4,9,1,10,2,4,10,3,5},{4,10,10,3,6,1,3,9,8,8},{4,4,6,10,10,10,2,10,8,8},{9,10,2,4,1,2,2,6,5,7},{2,9,2,6,1,4,7,6,10,9},{8,8,2,10,8,2,3,9,5,3},{2,10,9,3,5,1,7,4,5,6},{2,3,9,2,5,10,2,7,1,8},{9,10,4,10,7,4,9,3,1,6}};
        System.out.println(p.minimumEffortPath(heights));

    }

    public int minimumEffortPath(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return 0;
        }

        this.minEffort = Integer.MAX_VALUE;
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        dfs(heights, 0, 0, 0, visited);
        return minEffort;
    }

    int minEffort;
    private void dfs(int[][] heights, int i, int j, int maxEffort, Set<Integer> visited) {
        int m = heights.length, n = heights[0].length;
        if (i == m-1 && j == n-1) {
            minEffort = Math.min(minEffort, maxEffort);
            return;
        }

        int k = 10000;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        for(int[] dir : dirs) {
            int i2 = i + dir[0], j2 = j+dir[1];
            if (0 <= i2 && i2 < m && 0 <= j2 && j2 < n && !visited.contains(i2*k + j2)) {
                int effort = Math.abs(heights[i][j] - heights[i2][j2]);
                if (effort < minEffort) {
                    visited.add(i2 * k + j2);
                    dfs(heights, i2, j2, Math.max(effort, maxEffort), visited);
                    visited.remove(i2 * k + j2);
                }
            }
        }

        return;
    }
}
