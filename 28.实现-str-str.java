/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    // kmp算法
    public int strStr(String haystack, String needle) {
        int hp = 0;
        int np = 0;
        if (needle.length() == 0) {
            return 0;
        }

        /**
         * 数组next表示pattern指定的下标前具有相同的字符串数量，语言组织能力不好，可能不是太好理解，我举个例子吧
         * ，比如ABCABA，数组next[0]是-1，这个是固定的，因为第一个A前面是没有字符的，next[1]是0，因为B的前面就一个A，没有
         * 重复的，所以是0,同理next[2]也是,next[3]也是0,而next[4]是1，因为next[4]所指向的是第二个B，第二个B前面有一个A和
         * 第一个A相同，所以是1,next[5]是2，因为next[5]所指向的是最后一个Ａ，因为前面的Ａ对比成功，并且Ｂ也对比成功，所以是２，
         * 也就是ＡＢ两个字符串匹配成功,再举个例子，比如WABCABA，数组除了第一个为-1，其他的都是为0，因为只有第一个匹配成功之后
         * 才能匹配后面的，虽然后面的AB和前面的AB匹配成功，但是后面AB的前面是C和前面AB的前面一个W不匹配，所以后面的匹配都是0.
         * 要记住只有指定字符前面的字符和第一个字符匹配成功的时候才能往后匹配，否则后面的永远都是先和第一个匹配。
         */

         // next数组记录needle模式串中相同子串的数量,例如ABCABA中，AB有一个重复，那么后面那个AB记录位1,2，这用来记录前面那个相同子串的位置
         // 这样如果匹配失败，我们能快速定位到前面相邻的相同子串所在位置，如果有相同子串，就不用重新开始匹配了,直接在已匹配的子串后面开始
         // ABCABCABD 如果是这种，ABC是完全匹配，那第二个ABC分别就对应1，2，3；后面那个AB就直接从最后一个完全匹配的字符串后开始，这是开始值就是3
        int[] next = new int[needle.length()]; 

        getNext(needle, next);
        while (hp < haystack.length() && np < needle.length()) {
            if (np == -1 || haystack.charAt(hp) == needle.charAt(np)) {
                hp++;
                np++;
            } else {
                np = next[np];
            }

            if (np == needle.length()) {
                return hp - np;
            }
        }
        return -1;
    }

    private void getNext(String needle, int[] next) {
        int len = needle.length();
        int i = 0;
        int j = -1; // 从匹配成功处开始
        next[0] = -1;
        while (i < len - 1) {
            // 如果当前
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                i++; // i是当前字符串的遍历指针
                j++; // 如果有相同字符就+1
                next[i] = j; // 用来记录当前字符是第几个重复字符
            }else{
                j = next[j]; // 当当前字符与前面字符不匹配时，就将j回退到最后一个完全匹配的字符后面
            }
        }
    }

    // 使用java特性
    // public int strStr(String haystack, String needle) {
    // int length = needle.length();
    // for(int start=0; start<haystack.length()-length+1; start++) {
    // if(haystack.substring(start, start+length).equals(needle)){
    // return start;
    // }
    // }
    // return -1;
    // }

    // 暴力匹配进阶
    // public int strStr(String haystack, String needle) {
    // int hp = 0;
    // int np = 0;
    // if(needle.length() == 0) {
    // return 0;
    // }

    // while(hp<haystack.length() && np<needle.length()) {
    // // 如果匹配成功就两个串索引一起向后移
    // if(haystack.charAt(hp) == needle.charAt(np)) {
    // hp++;
    // np++;
    // }else{ // 如果匹配失败，hp退回匹配开始+1,np退回匹配开始
    // hp = hp-np+1;
    // np = 0;
    // }

    // // 当np指向末尾，结束匹配
    // if(np == needle.length()) {
    // return hp-np;
    // }
    // }
    // return -1;
    // }

    // 暴力匹配
    // public int strStr(String haystack, String needle) {

    // int hp = 0;
    // int np = 0;
    // // 如果两者相等
    // if(Objects.equals(haystack, needle)) {
    // return 0;
    // }

    // while(hp <= haystack.length()-needle.length()) {
    // int temp = hp;
    // boolean flag = true;

    // for (int i = 0; i < needle.length(); i++) {
    // // 如果模式串中存在不同字符串,停止当前匹配
    // if(haystack.charAt(temp) != needle.charAt(i)) {
    // flag = false;
    // break;
    // }
    // temp++;
    // }

    // // 如果没被改变，则表示当前这一轮匹配成功，返回hp值
    // if(flag) {
    // return hp;
    // }
    // hp++;
    // }
    // return -1;
    // }
}
// @lc code=end
