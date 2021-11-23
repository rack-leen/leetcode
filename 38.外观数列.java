/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        String st = "1";
        for (int i = 2; i <= n; i++) {
            st = countAndSayHelper(st);
        }
        return st;
    }

    /**
     * 将输入的字符串修改味外观字符串
     * @param string
     * @return
     */
    private String countAndSayHelper(String string) {
        int len = string.length();
        StringBuffer sb = new StringBuffer();
        int count = 1;
        for (int i = 0; i < len; i++) {
            char ch = string.charAt(i);
            if(i == len-1) {
                sb.append(count)
                .append(ch);
                break;
            }

            if(ch == string.charAt(i+1)) {
                count++;
            }else{
                sb.append(String.valueOf(count))
                .append(String.valueOf(ch));
                count = 1;
            }
        }
        return sb.toString();
    }
}
// @lc code=end

