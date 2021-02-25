package m;

//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
//
// 注意：本题相对原题稍作改动
//
// 示例：
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4
//
// 说明：
//
// 给定的 k 保证是有效的。
// Related Topics 链表 双指针
// 👍 54 👎 0

import base.ListNode;

public class M0202 {

    /**
     * 比较锉的方法一
     */
    public int kthToLast1(ListNode head, int k) {

        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }


        int idx = 0;
        while (idx < length - k) {
            head = head.next;
            idx++;
        }

        return head.val;
    }

    /**
     * 双指针法
     */
    public int kthToLast2(ListNode head, int k) {

        ListNode first = head;
        ListNode second = head;
        while (k-- > 0) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second.val;
    }
}
