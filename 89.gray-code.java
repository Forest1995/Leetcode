import java.util.ArrayList;

/*
 * @lc app=leetcode id=89 lang=java
 *
 * [89] Gray Code
 *
 * https://leetcode.com/problems/gray-code/description/
 *
 * algorithms
 * Medium (44.91%)
 * Total Accepted:    126.9K
 * Total Submissions: 282.3K
 * Testcase Example:  '2'
 *
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * Example 1:
 * 
 * 
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 * 
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 0
 * Output: [0]
 * Explanation: We define the gray code sequence to begin with 0.
 * A gray code sequence of n has size = 2^n, which for n = 0 the size is 2^0 =
 * 1.
 * Therefore, for n = 0 the gray code sequence is [0].
 * 
 * 思路：每当n 变大一位时，可以发现新加的数和原来的数是对称的 *除了第一位是一
 * 例如 原来是  0 1  现在加了一位变成   00 01 | 11 10 
 * 000 001 011 010 | 110 111 101 100
 * 根据以上规律，每次n增加时，将已有的数字（已存在数组里的数字）从后往前依次与 1 或一下
 * 并把结果加到 数组里，就形成了多一位的 greycode。
 * 
 */ 
class Solution {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i=0; i<n ;i++){
            int size = result.size();
            for(int k= size-1 ; k >=0 ;k--){
                result.add(result.get(k)|1<<i);
            }
        }
        return result;
    }
}

