package org.benjamin.list;

public interface ILinkedList<T> {
    // 返回节点数目
    public int size();
    // 返回链表是否为空
    default boolean isEmpty() {
        return size() == 0;
    }
    // 获取第index位置的节点
    public ListNode<T> getNode(int index);
    // 获取第index位置的节点的值
    default T get(int index) {
        return getNode(index).val;
    }
    // 获取第1个节点的值
    default T getFirst() {
        return get(0);
    }
    // 获取最后一个节点的值
    default T getLast() {
        return get(size() -1);
    }
    // 将节点插入到第index位置之前
    public void insert(int index, T t);
    // 将节点插入第一个节点处。
    default void insertFirst(T t) {
        insert(0, t);
    }
    // 将节点追加到链表的末尾
    default void appendLast(T t) {
        insert(size(), t);
    }
    // 删除index位置的节点
    public void delete(int index);
    // 删除第一个节点
    default void deleteFirst() {
        delete(0);
    }
    // 删除最后一个节点
    default void deleteLast() {
        delete(size()-1);
    }

    default void print(ListNode<T> t) {
        System.out.println("-------");
        while(t != null) {
            System.out.println(t);
            t = t.next;
        }
    }

    default void print() {
        print(getNode(0));
    }
}
