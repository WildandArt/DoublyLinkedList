package com.DoublyLinkedList.Impl;

import com.DoublyLinkedList.DoublyLinkedList;
import com.DoublyLinkedList.Node;

public class DoublyLinkedListImpl<T> implements DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedListImpl() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public Node<T> pushToFront(T element) {
        Node<T> node = new NodeImpl<>(element);

        if (isEmpty()) {

            head = tail = node;

        } else {

            insertAtPosition(node, null, head);
            head = node;

        }

        return node;
    }

    @Override
    public Node<T> pushToBack(T element) {
        Node<T> node = new NodeImpl<>(element);

        if (isEmpty()) {

            head = tail = node;

        } else {

            insertAtPosition(node, tail, null);
            tail = node;

        }

        return node;
    }

    private void insertAtPosition(Node<T> node, Node<T> prevNode, Node<T> nextNode) {
        if (prevNode != null) {
            prevNode.setNext(node);
            node.setPrev(prevNode);
        }
    
        if (nextNode != null) {
            nextNode.setPrev(node);
            node.setNext(nextNode);
        }
    }

    @Override
    public Node<T> insertBefore(Node<T> node, T data) {

        if (isEmpty() || node == null) {
            return null;
        }

        if (node == head) {
            return this.pushToFront(data);
        }

        Node<T> newNode = new NodeImpl<>(data);

        insertBetween(newNode, node.getPrev(), node);

        return newNode;
    }

    private void insertBetween(Node<T> newNode, Node<T> prevNode, Node<T> nextNode) {
        newNode.setPrev(prevNode);
        newNode.setNext(nextNode);
    
        if (prevNode != null) {
            prevNode.setNext(newNode);
        }
    
        if (nextNode != null) {
            nextNode.setPrev(newNode);
        }
    }

    @Override
    public T popFront() {
        if (isEmpty()) {
            throw new RuntimeException("No element to pop");
        }
        T data = head.getData();
        if (head == tail) {
            head = tail = null;
            return null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }
        return data;
    }

    @Override
    public T popBack() {
        if (tail == null) {
            throw new RuntimeException("No element to pop");
        }
        T data = tail.getData();
        if (head == tail) {
            head = tail = null;
            return null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        return data;
    }

    @Override
    public int count() {
        int counter = 0;
        Node<T> iterator = head;
        while (iterator != null) {
            counter++;
            iterator = iterator.getNext();
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    @Override
    public int remove(T data) {
        if (isEmpty()) {
            return 0;
        }

        Node<T> node = findNodeByData(data);
        if (node != null) {
            remove(node);
            return 1;
        }
        return 0;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= this.count()) {
            throw new RuntimeException("Out of Bound Exception");
        }

        Node<T> node = getNodeByIndex(index);
        if (node != null) {
            return remove(node);
        }
        return null;
    }

    @Override
    public T remove(Node<T> node) {
        if (node == null || isEmpty()) {
            return null;
        }

        T data = node.getData();
        
        if (node == head) {
            popFront();
        } else if (node == tail) {
            popBack();
        } else {
            // node is in the middle
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }

        return data;
    }

    private Node<T> findNodeByData(T data) {
        Node<T> iterator = head;
        while (iterator != null) {
            if (iterator.getData().equals(data)) {
                return iterator;
            }
            iterator = iterator.getNext();
        }
        return null;
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> iterator = head;
        for (int counter = 0; iterator != null; counter++) {
            if (counter == index) {
                return iterator;
            }
            iterator = iterator.getNext();
        }
        return null;
    }

    @Override
    public T getData(Node<T> node) {
        return node == null ? null : node.getData();
    }

    @Override
    public Node<T> getHead() {
        return head;
    }

    @Override
    public Node<T> getTail() {
        return tail;
    }

    @Override
    public Node<T> getPrev(Node<T> node) {
        return node.getPrev();
    }

    @Override
    public Node<T> getNext(Node<T> node) {
        return node.getNext();
    }

    @Override
    public String toString() {
        StringBuilder objectString = new StringBuilder("|");
        Node<T> iterator = head;
        while (iterator != null) {

            objectString.append(iterator.getData());

            if (iterator.getNext() != null) {

                objectString.append(", ");
                
            }
            iterator = iterator.getNext();

        }
        objectString.append("|");
        return objectString.toString();
    }

    @Override
    public void splice(Node<T> dest, Node<T> from, Node<T> to) {
        if (dest == null || from == null || to == null) {
            throw new RuntimeException("Invalid input to splice");
        }

        if (dest == head) {
            to.setNext(head);
            head.setPrev(to);
            head = to;
        } else if (dest == tail) {
            from.setPrev(dest.getPrev());
            dest.getPrev().setNext(from);
            to.setNext(dest);
            dest.setPrev(to);
        } else {
            Node<T> destPrev = dest.getPrev();
            from.setPrev(destPrev);
            destPrev.setNext(from);
            to.setNext(dest);
            dest.setPrev(to);
        }
    }
}


