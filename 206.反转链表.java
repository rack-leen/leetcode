import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList(ListNode head) {
        // 终止条件，也是链表的头
        if(head == null || head.next == null) {
            return head;
        }

        // 用于head头节点后的链表反转
        ListNode reverse = reverseList(head.next);

        // 反转后,head.next就成为末尾了
        // 我们需要将head添加到head.next末尾,需要修改head指向
        head.next.next = head; // 把最初的head放在head.next的后面
        head.next = null; // head链接关系更新后，head作为末尾，把head.next==null
        return reverse;

    }
    // 栈
    // public ListNode reverseList(ListNode head) {
    //     Stack<ListNode> stack = new Stack<>();
    //     while(head != null) {
    //         stack.push(head);
    //         head = head.next;
    //     }

    //     if(stack.isEmpty()) {
    //         return null;
    //     }

    //     ListNode newHead = stack.pop();
    //     ListNode resNode = newHead; 
    //     while(!stack.isEmpty()) {
    //         ListNode temp = stack.pop();
    //         newHead.next = temp;
    //         newHead = newHead.next;
    //     }

    //     newHead.next = null;
    //     return resNode;
    // }
    // 双链表
    // public ListNode reverseList(ListNode head) {
    //     ListNode newhead = null;
        
    //     while(head != null) {
    //         // 先把原链表当前节点摘出
    //         ListNode temp = head.next;
    //         // 在新链表前面增加节点，当前原节点就放在新链表前面
    //         // 原节点的后面链接关系由原链表转为新链表
    //         head.next = newhead;
    //         // 把当前节点给新链表
    //         newhead = head;
    //         head = temp;
    //     }
    //     return newhead;
    // }
}
// @lc code=end

