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