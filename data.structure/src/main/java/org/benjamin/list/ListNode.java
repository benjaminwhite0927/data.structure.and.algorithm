package org.benjamin.list;

public class ListNode<T> {
    T val;
    ListNode next;
    ListNode() {}
    ListNode(T val) { this.val = val; }
    ListNode(T val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
