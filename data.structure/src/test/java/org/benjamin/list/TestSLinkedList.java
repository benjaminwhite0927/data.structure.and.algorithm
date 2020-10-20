package org.benjamin.list;

import org.junit.Test;

public class TestSLinkedList {

    @Test
    public void testAppend() {
        SLinkedList<String> linkedList = new SLinkedList<String>();
        for (int i = 0; i < 10; i++) {
            linkedList.insert(0, "A" + i);
        }
        linkedList.print(linkedList.getNode(0));
        linkedList.insertFirst("F");
        linkedList.print(linkedList.getNode(0));
        linkedList.appendLast("L");
        linkedList.print(linkedList.getNode(0));
        linkedList.insert(5, "5555");
        linkedList.print(linkedList.getNode(0));

        linkedList.deleteLast();
        linkedList.print(linkedList.getNode(0));
        linkedList.deleteFirst();
        linkedList.print(linkedList.getNode(0));
        linkedList.delete(5);
        linkedList.print(linkedList.getNode(0));
    }
}
