package com.apenasolinco.leetcodae;

/**
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/description/">Leet 21: Merge Two Sorted Lists</a>
 */
public class MergeTwoSortedLists21 {
    public static void main(String[] args) {
        MergeTwoSortedLists21 mtsl21 = new MergeTwoSortedLists21();
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode res = mtsl21.mergeTwoLists(list1, list2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                current = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                current = list2;
                list2 = list2.next;
            }
        }

        current.next = list1 != null ? list1 : list2;
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
