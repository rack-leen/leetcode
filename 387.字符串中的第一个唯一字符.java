/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    // 数组
    public int firstUniqChar(String s) {
        int length = s.length(); 
        // 将英文字母转为数字，总共有26个
        int[] count = new int[26];
        for(int i=0; i<length; i++) {
            count[s.charAt(i)-'a']++;
        }

        for(int i=0; i<length; i++) {
            if(count[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    // 哈希表
    // public int firstUniqChar(String s) {
    //     int length = s.length();
    //     Map<Character, Integer> map = new HashMap<>();
    //     for(int i=0; i<length; i++) {
    //         Character ch = s.charAt(i);
    //         map.put(ch, map.getOrDefault(ch, 0)+1);
    //     }

    //     for(int i=0; i<length; i++) {
    //         if(map.get(s.charAt(i)) == 1) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }
}
// @lc code=end

