package m;

import base.ListNode;

import java.util.HashSet;
import java.util.Set;

public class M0201 {

    /**
     * 基础解法，使用缓冲区
     */
    public ListNode removeDuplicateNodes1(ListNode head) {

        if (head == null) {
            return head;
        }

        Set<Integer> numberSet = new HashSet<>();

        ListNode result = head;
        ListNode pre = head;
        head = head.next;
        numberSet.add(pre.val);
        while (head != null) {
            if (numberSet.contains(head.val)) {
                head = head.next;
                pre.next = head;
            } else {
                pre = head;
                head = head.next;
                numberSet.add(pre.val);
            }
        }

        return result;
    }

    /**
     * 题目要求的进阶解法
     * 不使用缓存区
     * <p>
     * 实际上就是暴力解法
     */
    public ListNode removeDuplicateNodes(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode result = head;

        while (head != null) {
            ListNode curr = head;
            while (curr.next != null) {
                if (curr.next.val == head.val) {
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
            }
            head = head.next;
        }

        return result;
    }
}
