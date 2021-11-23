/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    // 倒向遍历
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String temp = strs[i];
            while (temp.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

            }
        }
        return prefix;
    }
    // 正向遍历
    // public String longestCommonPrefix(String[] strs) {
    // if (strs.length == 0) {
    // return "";
    // }

    // String prefix = strs[0];
    // for (int i = 1; i < strs.length; i++) {
    // String temp = strs[i];
    // int pIndex = 0;
    // int sIndex = 0;
    // StringBuffer sb = new StringBuffer();
    // while (pIndex < prefix.length() && sIndex < temp.length()) {
    // if (prefix.charAt(pIndex) != temp.charAt(sIndex)) {
    // break;
    // }

    // sb.append(prefix.charAt(pIndex));
    // pIndex++;
    // sIndex++;
    // }
    // prefix = sb.toString();
    // }
    // return prefix;
    // }
}
// @lc code=end
