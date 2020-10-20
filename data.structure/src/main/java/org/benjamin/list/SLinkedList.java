package org.benjamin.list;

public class SLinkedList<T> implements ILinkedList<T> {
    private int count = 0;
    private ListNode  head = new ListNode();

    @Override
    public int size() {
        return count;
    }

    @Override
    public ListNode<T> getNode(int index) {
        if(index<0 || index>count) {
            throw new IndexOutOfBoundsException();
        }

        ListNode<T> node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public void insert(int index, T t) {
        if(index<0 || index>count) {
            throw new IndexOutOfBoundsException();
        }

        ListNode<T> node = new ListNode<>(t);
        ListNode<T> iNode;
        if(index == 0) {
            iNode = head;
//            node.next = head.next;
//            head.next = node;
//            count ++;
//            return;
        } else {
            iNode = getNode(index-1);
        }

//        ListNode<T> iNode = getNode(index-1);
        node.next = iNode.next;
        iNode.next = node;
        count ++;
    }

    @Override
    public void delete(int index) {
        if(index<0 || index>count) {
            throw new IndexOutOfBoundsException();
        }

        ListNode<T> dNode;
        if(index == 0) {
            dNode = head;
//            head.next = getNode(0).next;
//            count--;
//            return;
        } else {
            dNode = getNode(index-1);
        }
//        ListNode<T> dNode = getNode(index-1);
        dNode.next = dNode.next.next;

        count --;
    }
}
