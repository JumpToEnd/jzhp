package m;

import base.ListNode;

//给定两个用链表表示的整数，每个节点包含一个数位。
//
// 这些数位是反向存放的，也就是个位排在链表首部。
//
// 编写函数对这两个整数求和，并用链表形式返回结果。
//
//
//
// 示例：
//
// 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
//
//
// 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
//
// 示例：
//
// 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
//
// Related Topics 链表 数学
// 👍 50 👎 0
public class M0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode result = head;

        int carry = 0;
        while (l1 != null && l2 != null) {
            ListNode node = new ListNode((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val + carry) / 10;
            head.next = node;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            ListNode node = new ListNode((l1.val + carry) % 10);
            carry = (l1.val + carry) / 10;
            head.next = node;
            head = head.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            ListNode node = new ListNode((l2.val + carry) % 10);
            carry = (l2.val + carry) / 10;
            head.next = node;
            head = head.next;
            l2 = l2.next;
        }

        if (carry == 1) {
            ListNode node = new ListNode(1);
            head.next = node;
        }

        return result.next;
    }
}
