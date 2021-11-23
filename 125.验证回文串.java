/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    // 递归
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        return isPalindromeHelper(s, left, right);
    }

    private boolean isPalindromeHelper(String s, int left, int right) {
        if (left >= right) {
            return true;
        }

        // 如果schar不是字母就直接+1
        while (left < right && !Character.isLetterOrDigit(Character.toLowerCase(s.charAt(left)))) {
            left++;
        }

        while (left < right && !Character.isLetterOrDigit(Character.toLowerCase(s.charAt(right)))) {
            right--;
        }

        return Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))
                && isPalindromeHelper(s, ++left, --right);
    }
    // 正则匹配
    // public boolean isPalindrome(String s) {
    // s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    // String r = new StringBuffer(s).reverse().toString();
    // return s.equals(r);
    // }
    // // 双指针
    // public boolean isPalindrome(String s) {
    // int left = 0;
    // int right = s.length()-1;

    // while(left<right) {
    // char schar = Character.toLowerCase(s.charAt(left));
    // char tchar = Character.toLowerCase(s.charAt(right));

    // // 如果schar不是字母就直接+1
    // if(!Character.isLetterOrDigit(schar)) {
    // left++;
    // continue;
    // }

    // if(!Character.isLetterOrDigit(tchar)) {
    // right--;
    // continue;
    // }

    // if(schar != tchar) {
    // return false;
    // }
    // left++;
    // right--;
    // }

    // return true;
    // }
}
// @lc code=end
