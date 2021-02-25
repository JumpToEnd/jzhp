package m;
//编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。
//分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
//
// 示例:
//
// 输入: head = 3->5->8->5->10->2->1, x = 5
//输出: 3->1->2->10->5->5->8
//
// Related Topics 链表 双指针
// 👍 50 👎 0

import base.ListNode;

public class M0204 {

    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode rightHead = right;
        ListNode leftHead = left;

        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        // 此时有可能后面还有元素，复用head时
        right.next = null;
        left.next = rightHead.next;
        return leftHead.next;

    }
}
