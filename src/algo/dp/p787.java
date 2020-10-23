package algo.dp;

import common.ArrayUtils;

import java.util.*;

/*

https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/361711/Java-DFSBFSBellman-Ford-Dijkstra's

 */
public class p787 {
    public static void main(String[] args) {
        p787 p = new p787();
//        int n = 3, src = 0, dst = 2, K = 0;
//         int n = 3, src = 0, dst = 2, K = 1;
//         int[][] flights = new int[][] {{0,1,100}, {1,2,100}, {0,2,500}};
//        int n = 5, src = 2, dst = 1, K = 1;
//        int[][] flights = new int[][] {{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}};
//        int n = 2, src = 0, dst = 1, K = 1;
//        int[][] flights = new int[][] {{1,0,5}};
//        int n = 3, src = 1, dst = 2, K = 1;
//        int[][] flights = new int[][] {{0,1,2},{1,2,1},{2,0,10}};
        int n = 11, src = 0, dst = 2, K = 4;
        int[][] flights = {{0,3,3},{3,4,3},{4,1,3},{0,5,1},{5,1,100},{0,6,2},{6,1,100},{0,7,1},{7,8,1},{8,9,1},{9,1,1},{1,10,1},{10,2,1},{1,2,100}};
        System.out.println(p.findCheapestPrice(n, flights, src, dst, K));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // return findCheapestPriceBFS(n, flights, src, dst, K);
        // return findCheapestPriceDFS(n, flights, src, dst, K);
        // return bellmanFord(n, flights, src, dst, K+1);
        return dijkstras(n, flights, src, dst, K+1);
    }

    public int dijkstras(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) { return 0; }
        int[][] g = buildAdj(n, flights);

        PriorityQueue<List<Integer>> heap = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return Integer.compare(o1.get(0), o2.get(0));
            }
        });

        Set<Integer> settled = new HashSet<>();
        int res = Integer.MAX_VALUE;
        heap.offer(Arrays.asList(new Integer[] {0, src, 0})); // dist, node, stop
        System.out.println(heap);
        while(!heap.isEmpty()) {
            List<Integer> cur = heap.poll();
            int dist = cur.get(0), u = cur.get(1), k = cur.get(2);
            settled.add(u);
            if (u == dst) {
                return dist;
            }
            // if (k == K) {  continue; }

            for(int v = 0; v < n; v++) {
                if (g[u][v] > 0) {// && !settled.contains(v)) {
                    heap.offer(Arrays.asList(new Integer[] {dist + g[u][v], v, k+1}));
                }
            }

            // System.out.println(heap + " , settled " + settled);
        }

        return -1;
    }

    /*
    BFS
    1. build adjacency graph
    2. bfs till K+1 (don't care loop since bound by k)
     */
    public int findCheapestPriceBFS(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) { return 0; }
        int[][] g = buildAdj(n, flights);
        return bfs(n, flights, src, dst, K);
    }

    public int bfs(int n, int[][] flights, int src, int dst, int K) {
        int res = Integer.MAX_VALUE;
        int[][] g = buildAdj(n, flights);
        Queue<int[]> q1 = new LinkedList<>();
        q1.add(new int[]{src, 0});
        int s = 0;
        while(!q1.isEmpty() && s <= K) {
            s++;
            Queue<int[]> q2 = new LinkedList<>();
            while(!q1.isEmpty()) {
                int[] cur = q1.poll();
                int u = cur[0], d = cur[1];
                for(int v = 0; v < n; v++) {
                    if (g[u][v] > 0) {
                        if (dst == v) {
                            res = Math.min(res, d+g[u][v]);
                        }
                        q2.add(new int[]{v, d+g[u][v]});
                    }
                }
            }
            q1 = q2;
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /*
    DFS
    1. build adjacency graph
    2. bfs till K+1 (don't care loop since bound by k)
     */
    public int findCheapestPriceDFS(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) { return 0; }
        int[][] g = buildAdj(n, flights);

        this.minCost = Integer.MAX_VALUE;
        Set<Integer> visited = new HashSet<>();
        visited.add(src);
        dfs(n, g, dst, src, 0, visited, K + 2);
        return this.minCost == Integer.MAX_VALUE ? -1 : minCost ;
    }

    int minCost;
    private void dfs(int n, int[][] g, int dst, int cur, int cost, Set<Integer> visited, int K) {
        if (cur == dst) {
            minCost = Math.min(minCost, cost);
            return;
        }

        if (cur > minCost || visited.size() == K) {
            return;
        }

        for(int v = 0; v < n; v++) {
            if (g[cur][v] > 0 && !visited.contains(v)) {
                visited.add(v);
                dfs(n, g, dst, v, cost + g[cur][v], visited, K);
                visited.remove(v);
            }
        }
    }

    private int[][] buildAdj(int n, int[][] flights) {
        int[][] g = new int[n][n];
        for(int[] f : flights) {
            int u = f[0], v = f[1], d = f[2];
            g[u][v]  = d;
        }
        return g;
    }

    public int bellmanFord(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) { return 0; }
        int[][] dist = new int[K+1][n];
        Arrays.fill(dist[0], Integer.MAX_VALUE);
        dist[0][src] = 0;
        // System.out.println(ArrayUtils.dumpArray2D(dist));

        for(int k = 1; k <= K; k++) {
            dist[k] = Arrays.copyOf(dist[k-1], n);
            for(int[] f : flights) {
                int curr = f[0], next = f[1], price = f[2];
                if (dist[k-1][curr] < Integer.MAX_VALUE && dist[k-1][curr] + price < dist[k][next]) {
                    dist[k][next] = dist[k-1][curr] + price;
                }
            }
            // System.out.println(ArrayUtils.dumpArray2D(dist));
        }
        return dist[K][dst] == Integer.MAX_VALUE ? -1 : dist[K][dst];
    }

    public int bellmanFord2(int n, int[][] flights, int src, int dst, int K) {
        int[] cost=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;
        System.out.println(ArrayUtils.dumpArray(cost));
        for(int i=0;i<=K;i++)
        {
            int[] temp= Arrays.copyOf(cost,n);
            for(int[] f: flights)
            {
                int curr=f[0],next=f[1],price=f[2];
                if(cost[curr]==Integer.MAX_VALUE)
                    continue;
                temp[next]=Math.min(temp[next],cost[curr]+price);
            }
            cost=temp;
            System.out.println(ArrayUtils.dumpArray(cost));
        }
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
    }
}
