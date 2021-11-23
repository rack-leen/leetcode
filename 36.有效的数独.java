/*
 * @Author: your name
 * @Date: 2021-11-12 23:15:31
 * @LastEditTime: 2021-11-13 01:29:15
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: /leetcode/36.有效的数独.java
 */
/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    // 使用位运算方式实现
    public boolean isValidSudoku(char[][] board) {
        // 用一个数字作为存储容器，存储每行的9个数字是否出现
        // 取int的二进制后9位作为存储容器
         int[] line = new int[9];
         int[] col = new int[9];
         int[] cell = new int[9];

         int shift = 0;
        for(int i=0;i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                if(board[i][j] == '.') {
                    continue;
                }

                // 1 << board[i][j] 将board[i][j]位置的数字放入1的后9位中的第n位 0<n<10
                // n=9时, 100000000
                // n=8时, 010000000
                shift = 1 << board[i][j]-'0';
                int k=i/3*3+j/3;

                // 0&100000000=0 1&100000000>0
                // 当col,line,cell中当前位置数字不为0，表示已有与shift相同的数字存在
                if((line[j] & shift)>0 || (col[i] & shift) > 0 || (cell[k]&shift)>0) {
                    return false;
                }

                // 如果col,line,cell当前位置已有与shift，就=1,否则=0
                // col[i]=1/0 line[j]=1/0 cell[k]=1/0
                col[i] |= shift;
                line[j] |= shift;
                cell[k] |= shift;
            }
        }
        return true;
    }

    // 使用数组方式实现
    // public boolean isValidSudoku(char[][] board) {
    //     int len = board.length;
    //     int[][] line = new int[len][len];
    //     int[][] col = new int[len][len];
    //     int[][] cell = new int[len][len];

    //     for(int i=0; i<len; i++) {
    //         for(int j=0; j<len; j++) {
    //             // 如果当前遍历的位置不是数字则跳过
    //             if(board[i][j] == '.') {
    //                 continue;
    //             }

    //             // 如果当前遍历的数字
    //             int num = board[i][j]-'0'-1;

    //             // 找到单元格(3*3为一个单元格), 共有9个单元格
    //             int k = i/3*3+j/3;
    //             if(line[i][num] !=0 || col[j][num] !=0 || cell[k][num] !=0 ) {
    //                 return false;
    //             }

    //             line[i][num] = col[j][num] = cell[k][num] = 1;
    //         }
    //     }
    //     return true;
    // }
}
// @lc code=end

