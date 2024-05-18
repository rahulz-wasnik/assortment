package com.javaconcepts.linkedlist;


public class OddEvenLinkedList {

    public static ListNode oddEven(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode evenStartNode = head.next;
        ListNode odd = head;
        ListNode even = head.next;

        while (even != null && even.next != null) {
            odd.next = even.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenStartNode;

        return head;
    }

    public static void main(String[] args) {

        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(4);
        ListNode node_5 = new ListNode(5);

        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;
        node_5.next = null;

        ListNode head = oddEven(node_1);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

    }
}
