/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    // 一次遍历
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();

        // 只会出现新字符和旧字符两种状态
        int[] map = new int[26];
        int count = 0;
        for (int i = 0; i < tchar.length; i++) {
            // 新字符+1
            if(++map[schar[i]-'a'] == 1) {
                count++;
            }

            // 旧字符-1
            if(--map[tchar[i]-'a'] == 0) {
                count--;
            }

            // 达至平衡
        }
        return count == 0;
    }
    // 用排序
    // public boolean isAnagram(String s, String t) {
    // char[] schar = s.toCharArray();
    // char[] tchar = t.toCharArray();
    // Arrays.sort(schar);
    // Arrays.sort(tchar);

    // return Arrays.equals(schar, tchar);
    // }

    // 用hash表
    // public boolean isAnagram(String s, String t) {
    // char[] count = new char[26];
    // for (int i = 0; i < s.length(); i++) {
    // char ch = s.charAt(i);
    // count[ch-'a']++;
    // }

    // for (int i = 0; i < t.length(); i++) {
    // char ch = t.charAt(i);
    // count[ch-'a']--;
    // }

    // for(int i=0; i<count.length; i++) {
    // if(count[i] != 0) {
    // return false;
    // }
    // }
    // return true;
    // }
}
// @lc code=end
