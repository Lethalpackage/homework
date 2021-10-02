package com.company;

public class ListH<E> {

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }


    }

    int size = 0;

    Node<E> first;

    Node<E> last;

    public boolean add(E element) {
        linkLast(element);
        return true;
    }


    void linkLast(E element) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, element, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    public E get(int index) throws Exception {
        checkElementIndex(index);
        return node(index).item;
    }

    private Node<E> node (int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }


    public void checkElementIndex(int index) throws Exception {
        if (index < 0 || index >= size)
            throw new Exception("fail");

    }

    public int length () {
        return size;
    }
}
