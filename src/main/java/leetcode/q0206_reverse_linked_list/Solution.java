package leetcode.q0206_reverse_linked_list;

import ds.ListNode;
import util.Assert;
import util.Prints;

/**
 * 206. 反转链表  https://leetcode.cn/problems/reverse-linked-list/
 * 演示 Prints.list / Prints.str 构造和打印链表。
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.eq("5->4->3->2->1", Prints.str(s.reverseList(Prints.list(1, 2, 3, 4, 5))));
        Assert.eq("2->1", Prints.str(s.reverseList(Prints.list(1, 2))));
        Assert.done();
    }
}
