package com.DoublyLinkedList.Impl;

import com.DoublyLinkedList.Node;

public class NodeImpl<T> implements Node<T> {
    public T data;
    public Node<T> next;
    public Node<T> prev;

    public NodeImpl(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public Node<T> getNext() {
        return next;
    }

    @Override
    public void setNext(Node<T> node) {
        this.next = node;
    }

    @Override
    public Node<T> getPrev() {
        return prev;
    }

    @Override
    public void setPrev(Node<T> node) {
        this.prev = node;
    }
}

