import java.util.Stack;

/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    ListNode temp = null;
    // 递归法
    public boolean isPalindrome(ListNode head) {
        temp = head;
        return check(head);
    }
    private boolean check(ListNode head) {
        // 当整个链表递归完，终止条件
        if(head == null) {
            return true;
        }

        // 如果从后向前递归的head与从前向后遍历的temp节点值相等，则返回true,如果都是true，则是回文链表
        boolean res = check(head.next) && (temp.val == head.val);
        temp = temp.next;
        return res;
    }

    // 使用栈的方式解决
    // public boolean isPalindrome(ListNode head) {
    //     ListNode temp = head;
    //     Stack<ListNode> stack = new Stack<>();
    //     // 将链表压入栈
    //     while(temp != null) {
    //         stack.push(temp);
    //         temp = temp.next;
    //     }

    //     while(head != null) {
    //         ListNode stackNode = stack.pop();
    //         if(head.val != stackNode.val) {
    //             return false;
    //         }
    //         head = head.next;
    //     }
    //     return true;
    // }

    // 双指针法
    // 使用快慢指针，快指针比慢指针快一倍，快指针到末尾，慢指针到中点
    // 如果链表为奇数，慢指针需要向前走一步
    // 然后以慢指针为头节点反转后面链表
    // 快指针放在原链表头，这样快指针遍历前部分，慢指针遍历后部分
    // public boolean isPalindrome(ListNode head) {
    // ListNode fast = head, slow = head;

    // while(fast != null && fast.next != null) {
    // fast = fast.next.next; // 比slow快一倍,刚好fast到结尾，slow到中点
    // slow = slow.next;
    // }

    // if(fast != null) {
    // slow = slow.next;
    // }
    // slow = reserve(slow);

    // fast = head;

    // while(slow != null) {
    // if(fast.val != slow.val) {
    // return false;
    // }
    // slow = slow.next;
    // fast = fast.next;
    // }
    // return true;
    // }

    // private ListNode reserve(ListNode slow) {
    // ListNode res = null;
    // while(slow != null) {
    // ListNode temp = slow.next;
    // slow.next = res;
    // res = slow;
    // slow = temp;
    // }
    // return res;
    // }
}
// @lc code=end
