/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {

        // 直接交换(模拟旋转操作,从外圈开始旋转，一直往内圈递进)
        public void rotate(int[][] matrix) {
        int length = matrix.length;

        // i与j的初始值相同,表示内环的起点
        for(int i=0; i<length/2; i++) {
            for(int j=i; j<length-i-1; j++) {
                int temp = matrix[i][j];
                int m = length-j-1;  
                int n = length-i-1;  
    
                matrix[i][j] = matrix[m][i];  
                matrix[m][i] = matrix[n][m]; 
                matrix[n][m] = matrix[j][n];
                matrix[j][n] = temp;
            }
        }
    }

    // public void rotate(int[][] matrix) {
    //     int length = matrix.length;

    //     // 先上下文互换
    //     for(int i=0; i<length/2; i++) {
    //         int[] temp = matrix[i];
    //         matrix[i] = matrix[length-i-1];
    //         matrix[length-i-1] = temp;
    //     }

    //     // 然后沿对角线互换
    //     for(int i=0; i<length; ++i) {
    //         for(int j=i+1; j<length; ++j) {
    //             int temp = matrix[i][j];
    //             matrix[i][j] = matrix[j][i];
    //             matrix[j][i] = temp;
    //         }
    //     }
    // }
}
// @lc code=end

