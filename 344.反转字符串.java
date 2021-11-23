/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串
 */

// @lc code=start
class Solution {

    // 递归法
    public void reverseString(char[] s) {
        int length = s.length;
        int left = 0;
        int right = length - 1;
        reverseStringHelper(s, left, right);
    }

    public void reverseStringHelper(char[] s, int left, int right) {
        if(left>=right) {
            return;
        }
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        reverseStringHelper(s, ++left, --right);
    }
    // 双指针法
    // public void reverseString(char[] s) {
    // int length = s.length;
    // int left = 0;
    // int right = length-1;

    // while(left<right) {
    // char temp = s[left];
    // s[left] = s[right];
    // s[right] = temp;
    // left++;
    // right--;
    // }
    // }

    // 简单直接法
    // public void reverseString(char[] s) {
    // int length = s.length;
    // for(int i=0; i<length/2; i++) {
    // char temp = s[i];
    // s[i] = s[length-i-1];
    // s[length-i-1] = temp;
    // }
    // }
}
// @lc code=end
