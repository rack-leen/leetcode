import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // 快慢指针
    public boolean hasCycle(ListNode head) {
    }
    
    // 使用集合·
    // 环形链表的next指针永远不为空,只要为空，表示有尾节点，不能构成环
    // public boolean hasCycle(ListNode head) {
    //     Map<ListNode, Integer> map = new HashMap<>();
    //     while(head != null) {
    //         if(map.get(head) != null) {
    //             return true;
    //         }else {
    //             map.put(head, 0);
    //             head = head.next;
    //         }
    //     }
    //     return false;
    // }
}
// @lc code=end

