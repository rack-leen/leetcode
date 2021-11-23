/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // 递归
    // https://blog.csdn.net/Gabbana/article/details/105609784
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 终止条件，当在l1或l2遍历完成后就停止，后面的链表节点肯定是大于前面的
        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // 非递归
    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //     if(l1 == null) {
    //         return l2;
    //     }

    //     if(l2 == null) {
    //         return l1;
    //     }
    //     // 新链表
    //     ListNode res = new ListNode(0);
    //     // 用于遍历新链表
    //     ListNode curr = res;
    //     while(l1 != null && l2 != null) {
    //         // 如果当前l1的值小就将l1的节点挂在新链表后
    //         if(l1.val <= l2.val) {
    //             curr.next = l1;
    //             l1 = l1.next;
    //         }else{
    //             curr.next = l2;
    //             l2 = l2.next;
    //         }
    //         curr = curr.next;
    //     }

    //     // 将剩余不为空的链表挂在新链表后
    //     curr.next = l1 != null?l1:l2;
    //     return res.next; // 排除默认创建的节点
    // }
}
// @lc code=end

