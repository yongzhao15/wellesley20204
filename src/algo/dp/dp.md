# Dynamic Programing
## Key Concepts
* https://leetcode.com/problems/coin-change-2/solution/
  * Define the base cases for which the answer is obvious.
  * Develop the strategy to compute more complex case from more simple one.
  * Link the answer to base cases with this strategy.

## Problems
### 322 Coin Change
https://leetcode.com/problems/coin-change/
* minimum coin for given amount
* minCoin(amount) = min(minCoin(amount - value) + 1), value in coins

### 518 Coin Change 2
https://leetcode.com/problems/coin-change-2/
* number of ways to change
* what is the base case, or **cases**?
* same as https://leetcode.com/problems/combination-sum/

### 790 Domino and Tromino Tiling
https://leetcode.com/problems/domino-and-tromino-tiling/
* DP 
* no matter how big n is, it's still affected by 0;
* half DP and half math problem to optimize

### 787
https://leetcode.com/problems/cheapest-flights-within-k-stops/
https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/361711/Java-DFSBFSBellman-Ford-Dijkstra's
* BFS vs DFS: 
  * DFS is more straightforward than BFS
  * BFS needs to keep track of a pair {node, dist-so-far} and global min dist to all node 
* Bellman-Ford normal vs min dist K stops 
  * normal case: evaluate all edges in each iteration
  * min dist K stops: evaluate only edges where source vertex/node already reached.  
* Dijkstra nomal vs min dist K stops
  * normal case: settle on offer and skip settled afterwards
  * min dist K stops: no settle or keep visit settled