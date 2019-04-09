/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 *
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 *
 * algorithms
 * Medium (45.39%)
 * Total Accepted:    190.6K
 * Total Submissions: 418.6K
 * Testcase Example:  '3'
 *
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1 ... n?
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
 * 
 * 
 * 思路
 * 为了避免重复，将每个点作为root的情况都考虑一遍，然后把这些情况的数字相加就是答案 g(n)=f(1,n)+....+f(n,n);
 * 
 * 再考虑， 当计算(3,7)的时候，左边的可能性为 g(2) 右边的可能性为 g(4)因为连续4数字 1234 和4567可能数一样的
 * 所以
 * G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0) 

 * 
 * 
 */
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0]=dp[1]=1;   //base case
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}

