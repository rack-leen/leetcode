import java.util.Objects;

/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {

    // 递归法(当节点数很多时，不能用递归法,因为栈容量有限)
    // 递归是压栈出栈方式，最开始的在栈底，最后出来，最后的在栈顶，第一个出来
    // 因此递归是倒序向前排
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 从后往前遍历，找到节点位置
        int pos = length(head, n);
        if(pos == n) {
            return head.next;
        }
        return head;
    }

    private int length(ListNode node, int n) {
        // 压栈完成，到链表结尾了
        if(node == null) {
            return 0;
        }

        int pos = length(node.next, n)+1;
        // 当pos出栈位置已到达n的前一位，也就是需要移除的位置
        if(pos == n+1) {
            node.next = node.next.next;
        }

        return pos;
    }

    // 双指针法
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     ListNode fast = head;
    //     ListNode slow = head;

    //     // fast指针先走n步,与slow指针间隔n个节点
    //     // 当fast指针指向末尾时，slow指针刚好指向倒数第n+1个
    //     for (int i = 0; i < n; i++) {
    //         fast = fast.next;
    //     }

    //     // 当fast指针已经指向末尾了，就返回
    //     if(fast == null) {
    //         return head.next;
    //     }

    //     while(fast.next != null) {
    //         fast = fast.next;
    //         slow = slow.next;
    //     }
    //     slow.next = slow.next.next;
    //     return head;
    // }

    //非递归法
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     ListNode pre = head;
    //     // 先获取链表长度
    //     int length = length(head) - n;
       

    //     int last = length - n;
    //     if (last == 0) {
    //         return head.next;
    //     }

    //     for (int i = 0; i < last - 1; i++) {
    //         pre = pre.next;
    //     }
    //     pre.next = pre.next.next;
    //     return head;
    // }

    // private int length(ListNode head) {
    //     int length = 0;
    //     while (!Objects.isNull(head)) {
    //         length++;
    //         head = head.next;
    //     }
    //     return length;
    // }
}
// @lc code=end
