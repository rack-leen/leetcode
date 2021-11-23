/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        // 去除两边空格
        s = s.trim();
        int index = 0;
        int flag = 1;
        int num = 0;
        if(s.length() == 0) {
            return 0;
        }
        // 检查正负号
        if(s.charAt(index)=='+' | s.charAt(index) == '-') {
            flag = s.charAt(index++)=='+'?1:-1;
        }
        while(index < s.length()) {
            int dight = s.charAt(index)-'0';
            // 排除非数字
            if(dight<0 || dight>9) {
                break;
            }

            // 处理越界
            if(num>Integer.MAX_VALUE/10||(num==Integer.MAX_VALUE/10&dight>Integer.MAX_VALUE%10)) {
                return flag==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }

            num = num*10+dight;
            index++;
        }

        return num*flag;
    }
}
// @lc code=end

