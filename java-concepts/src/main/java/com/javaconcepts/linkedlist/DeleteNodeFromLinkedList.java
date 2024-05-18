package com.javaconcepts.linkedlist;

public class DeleteNodeFromLinkedList {

    ListNode prev;

    public void delete(ListNode node) {
        while (node != null && node.next != null) {

            node.val = node.next.val;

            prev = node;

            node = node.next;

        }
        prev.next = null;
    }

    public void print(ListNode node) {

        while (node != null) {
            System.out.print(node.val + " ---> ");
            node = node.next;
        }
    }

    public static void main(String[] args) {

        ListNode node_4 = new ListNode(4);
        ListNode node_5 = new ListNode(5);
        ListNode node_1 = new ListNode(1);
        ListNode node_9 = new ListNode(9);

        node_4.next = node_5;
        node_5.next = node_1;
        node_1.next = node_9;
        node_9.next = null;

        DeleteNodeFromLinkedList deleteNodeFromLinkedList = new DeleteNodeFromLinkedList();
        deleteNodeFromLinkedList.delete(node_5);
        deleteNodeFromLinkedList.print(node_4);
    }
}
