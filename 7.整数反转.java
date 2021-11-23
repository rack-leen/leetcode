/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int n = 0 ; 
        while(x != 0) {
            if(n<Integer.MIN_VALUE/10 || n > Integer.MAX_VALUE/10) {
                return 0;
            }
            n = n*10 + x%10;
            x=x/10;
        }
        return n;
    }
}
// @lc code=end

