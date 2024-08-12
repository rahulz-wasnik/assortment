package com.javaconcepts.leet.code;

class ListNode {
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


public class L21MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }
        curr.next = list1 != null ? list1 : list2;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode o3 = new ListNode(4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);

        ListNode oc = new ListNode(4);
        ListNode ob = new ListNode(3, oc);
        ListNode oa = new ListNode(1, ob);

        L21MergeTwoSortedList obj = new L21MergeTwoSortedList();
        ListNode mrg = obj.mergeTwoLists(o1, oa);
        while (mrg.next != null) {
            System.out.println(mrg.val);
            mrg = mrg.next;
        }
    }
}

// 1 8 9
// 4 5 9