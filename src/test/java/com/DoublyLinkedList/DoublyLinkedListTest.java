package com.DoublyLinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DoublyLinkedList.Impl.DoublyLinkedListImpl;
import com.DoublyLinkedList.Impl.NodeImpl;

import static org.junit.jupiter.api.Assertions.*;

// Test class for DoublyLinkedList interface
class DoublyLinkedListTest {

    private DoublyLinkedList<Integer> dll;

    @BeforeEach
    void setUp() {
        dll = new DoublyLinkedListImpl<Integer>();
    }
    @Test
    public void testInitialization() {
        assertTrue(dll.isEmpty(), "List should be empty after initialization");
        assertEquals(0, dll.count(), "Count should be 0 after initialization");
    }

    @Test
    @DisplayName("Test pushToFront() method - Empty List case")
    void testPushToFrontEmptyList() {

        Node <Integer> node = dll.pushToFront(10);
        assertEquals(1, dll.count());
        assertEquals(dll.isEmpty(), false);
        assertEquals(10, dll.getData(node));
        assertEquals(dll.getHead(), node);
        assertEquals(dll.getTail(), node);
    }
    @Test
    @DisplayName("Test pushToFront() method - Not Empty List case")
    void testPushToFrontNotEmptyList() {

        Node <Integer> node = dll.pushToFront(10);
        Node <Integer> node2 = dll.pushToFront(20);

        assertEquals(dll.isEmpty(), false);
        assertEquals(10, dll.getData(node));
        assertEquals(20, dll.getData(node2));

        assertEquals(dll.getNext(node2), node);
        assertEquals(dll.getPrev(node), node2);

        assertEquals(dll.getHead(), node2);
        assertNotEquals(dll.getHead(), dll.getTail());
        assertEquals(dll.getTail(), node);


        Node <Integer> node3 = dll.pushToFront(30);
        assertEquals(dll.getHead(), node3);
        assertEquals(dll.getTail(), node);
        assertEquals(30, dll.getData(node3));

    }

    @Test
    @DisplayName("Test pushToBack() method - empty list")
    void testPushToBack() {

        Node <Integer> node = dll.pushToBack(10);
        assertEquals(dll.isEmpty(), false);
        assertEquals(10, dll.getData(node));
        assertEquals(dll.count(), 1);
    }
    @Test
    @DisplayName("Test pushToBack() method - Not Empty list")
    void testPushToBackNotEmpty() {

        Node <Integer> node1 = dll.pushToBack(10);
        Node <Integer> node2 = dll.pushToBack(20);

        assertEquals(2, dll.count());

        assertEquals(dll.getNext(node1), node2);
        assertEquals(dll.getPrev(node2), node1);

        assertEquals(dll.getHead(), node1);
        assertNotEquals(dll.getHead(), dll.getTail());
        assertEquals(dll.getTail(), node2);

        assertEquals(10, dll.getData(node1));
        assertEquals(20, dll.getData(node2));
    }

    @Test
    @DisplayName("Test popFront() method")
    void testPopFrontEmptyList() {

        assertThrows(RuntimeException.class, () -> {
            dll.popFront();
        }, "Expected popFront() to throw, but it didn't");
        assertEquals(dll.count(), 0);

    }
    
    @Test
    @DisplayName("Test popFront() method")
    void testPopFront() {

        Node <Integer> node = dll.pushToBack(10);
        assertEquals(dll.count(), 1);
        assertEquals(dll.isEmpty(), false);
    
        assertEquals(null, dll.popFront());
    
        assertEquals(dll.count(), 0);
        assertEquals(dll.isEmpty(), true);

        dll.pushToBack(20);
        dll.pushToBack(30);
        dll.pushToBack(40);

        assertEquals(dll.count(), 3);
        assertEquals(20, dll.popFront());
        assertEquals(30, dll.popFront());
        assertEquals(null, dll.popFront());

    }

    @Test
    @DisplayName("Test popBack() method - empty List")
    void testPopBackEmptyList() {

        assertThrows(RuntimeException.class, () -> {
            dll.popBack();
        }, "Expected popFront() to throw, but it didn't");
        
    }

    @Test
    @DisplayName("Test popBack() method - one node")
    void testPopBackOneNode() {

        Node <Integer> node = dll.pushToBack(10);
        assertEquals(dll.count(), 1);
        assertEquals(dll.popBack(), null);

        assertEquals(dll.count(), 0);
    }
    @Test
    @DisplayName("Test popBack() method - multiple node")
    void testPopBackMultipleNodes() {

        Node <Integer> node = dll.pushToBack(10);
        Node <Integer> node2 = dll.pushToBack(20);
        Node <Integer> node3 = dll.pushToBack(30);
        
        assertEquals(dll.count(), 3);

        assertEquals(dll.popBack(), 30);
        assertEquals(dll.popBack(), 20);
        assertEquals(dll.popBack(), null);

        assertEquals(dll.count(), 0);
    }


    @Test
    @DisplayName("Test remove(int index) method")
    void testRemoveByIndex() {
        assertThrows(RuntimeException.class, () -> {
            dll.remove(0);
        }, "Out Of Bound");
        Node <Integer> node = dll.pushToBack(10);
        
        assertEquals(10, dll.remove(0));

        Node <Integer> node1 = dll.pushToBack(10);
        Node <Integer> node2 = dll.pushToBack(20);
        Node <Integer> node3 = dll.pushToBack(30);
        assertEquals(30, dll.remove(2));
        assertEquals(dll.count(), 2);
        assertEquals(10, dll.remove(0));
        assertEquals(20, dll.remove(0));
        assertEquals(dll.count(), 0);
    }

    @Test
    @DisplayName("Test remove(Object o) method")
    void testRemoveByObject() {
       //empty list
       Integer i = 1;
       assertEquals(dll.remove(i), 0);
       Node <Integer> node = dll.pushToBack(10);
       Integer data = 10;
       assertEquals(dll.remove(i), 0);
       assertEquals(dll.remove(data), 1);
    }

    @Test
    @DisplayName("Test remove(Object o) method")
    void testRemoveByObjectMultipleNodes() {
       //empty list
       Integer i = 1;
       Node <Integer> node1 = dll.pushToBack(10);
       Node <Integer> node2 = dll.pushToBack(20);
       Node <Integer> node3 = dll.pushToBack(30);
       
       assertEquals(dll.remove(i), 0);
       assertEquals(dll.remove(Integer.valueOf(10)), 1);
       assertEquals(dll.count(), 2);

       assertEquals(dll.remove(Integer.valueOf(20)), 1);
       assertEquals(dll.count(), 1);

       assertEquals(dll.remove(Integer.valueOf(30)), 1);
       assertEquals(dll.count(), 0);

       assertEquals(dll.getHead(), null);
       assertEquals(dll.getTail(), null);

    }
    @Test
    @DisplayName("Test remove(Node node) method")
    void testRemoveByIterator() {
        Node <Integer> node = null;
       
       assertEquals(dll.remove(node), null);
       Node <Integer> node1 = dll.pushToBack(10);
       assertEquals(dll.remove(node1), 10);
    }

    @Test
    @DisplayName("Test insertBefore")
    void testinsertBefore() {

        Node <Integer> node = null;
        assertEquals(dll.insertBefore(dll.getHead(), 10), null);
        Node <Integer> node10 = dll.pushToBack(10);

        Node <Integer> node20 = dll.insertBefore(node10, 20);
        assertEquals(dll.getData(node20), 20);
        assertEquals(dll.count(), 2);
        assertEquals(dll.getPrev(node10), node20);
        assertEquals(dll.getNext(node20), node10);

        assertEquals(dll.getHead(), node20);
        assertEquals(dll.getTail(), node10);
        assertNotEquals(dll.getTail(), dll.getHead());

        Node <Integer> node30 = dll.insertBefore(node10, 30);
        assertEquals(dll.getPrev(node10), node30);
        assertEquals(dll.getNext(node30), node10);
        assertEquals(dll.getNext(node20), node30);

        Node <Integer> node40 = dll.insertBefore(node30, 40);
        assertEquals(dll.getPrev(node40), node20);
        assertEquals(dll.getNext(node40), node30);
        assertEquals(dll.getNext(node20), node40);
        assertEquals(dll.getPrev(node30), node40);

    }

        @Test
        @DisplayName("Test count() method")
        void testCount() {
        assertEquals(0, dll.count(), "Count should be 0 for an empty list");

            dll.pushToFront(1);
            dll.pushToBack(2);

            assertEquals(2, dll.count(), "Count should be 2 after adding two elements");

            dll.popFront();

            assertEquals(1, dll.count(), "Count should be 1 after removing one element");
    }

    @Test
    @DisplayName("Test isEmpty() method")
    void testIsEmpty() {

        assertTrue(dll.isEmpty(), "List should be empty initially");

        dll.pushToFront(1);

        assertFalse(dll.isEmpty(), "List should not be empty after adding an element");

        dll.popFront();

        assertTrue(dll.isEmpty(), "List should be empty after removing the element");
    }

    @Test
    @DisplayName("Test Splice")
    void testSplice() {
        assertThrows(RuntimeException.class, () -> {
            dll.splice(null, null, null);
        }, "One of nodes is null");

        Node<Integer> from = new NodeImpl<Integer>(10);
        Node<Integer> to = from;

        Node<Integer> nodedest = dll.pushToFront(20);

        dll.splice(nodedest, from, to);

        assertEquals(dll.getPrev(nodedest), to);   
        assertEquals((nodedest), dll.getNext(to));
        assertEquals(dll.getHead(), to); 

        from = new NodeImpl<Integer>(50);
        to = new NodeImpl<Integer>(60);// 10 -> 30
        from.setNext(to);
        to.setPrev(from);

        dll.splice(dll.getTail(), from, to);

        assertEquals(dll.getTail().getPrev(), to);
        assertEquals(dll.getTail(), to.getNext());

        assertEquals(from.getPrev(), dll.getHead());
        assertEquals(from, dll.getHead().getNext());

        Node <Integer> dest = dll.getHead().getNext().getNext();
        assertEquals(dll.getData(dest), 60);
        from =  new NodeImpl<Integer>(70);
        to = new NodeImpl<Integer>(80);
        from.setNext(to);
        to.setPrev(from);

        dll.splice(dest, from, to);

        assertEquals(dest.getPrev().getNext(), dest);
        assertEquals(from.getData(), 70 );
        assertEquals(to.getData(), 80 );

        assertEquals(dest.getPrev().getData(), 80 );
        assertEquals(dest.getPrev().getNext(), dest );
        assertEquals(from.getPrev().getNext(), from );
        assertEquals(from.getPrev().getData(), 50 );

    }



@Test
@DisplayName("Test Connectivity with Two Lists")
void testConnectivity() {

    DoublyLinkedList<Integer> dll1 = new DoublyLinkedListImpl<>();

    dll1.pushToBack(10);
    dll1.pushToBack(20);
    dll1.pushToBack(30);
    dll1.pushToBack(40);
    dll1.pushToBack(50);
    dll1.pushToBack(60);

    testListConnectivity(dll1);

}

private void testListConnectivity(DoublyLinkedList<Integer> dll) {
    Node<Integer> start = dll.getHead();
    Node<Integer> end = dll.getTail();
    
    // Forward traversal check
    Node<Integer> current = start;
    Node<Integer> previous = null;

    while (current != null) {
        if (current.getPrev() != previous) {
            fail("Forward traversal failed in list: Node " + current.getData() + " has incorrect previous pointer.");
        }
        previous = current;
        current = dll.getNext(current);
    }

    // Check that the last node in forward traversal is the tail
    if (previous != end) {
        fail("Forward traversal failed in list: Last node should be the tail.");
    }

    current = end;
    previous = null;
    while (current != null) {
        if (current.getNext() != previous) {
            fail("Backward traversal failed in list: Node " + current.getData() + " has incorrect next pointer.");
        }
        previous = current;
        current = dll.getPrev(current);
    }

    // Check that the last node in backward traversal is the head
    if (previous != start) {
        fail("Backward traversal failed in list: Last node should be the head.");
    } 
    }

    @Test
    @DisplayName("toString should return correct string for an empty list")
    void testToStringEmptyList() {
        assertEquals("||", dll.toString(), "The string representation of an empty list should be '|'");
    }

    @Test
    @DisplayName("toString should return correct string for a single element list")
    void testToStringSingleElement() {
        dll.pushToFront(1);
        assertEquals("|1|", dll.toString(), "The string representation of a single element list should be '|1, |'");
    }

    @Test
    @DisplayName("toString should return correct string for a multiple elements list")
    void testToStringMultipleElements() {
        dll.pushToFront(1);
        dll.pushToBack(2);
        dll.pushToBack(3);
        assertEquals("|1, 2, 3|", dll.toString(), "The string representation of the list should be '|1, 2, 3, |'");
    }

    @Test
    @DisplayName("toString should reflect changes after removing elements")
    void testToStringAfterRemovingElements() {
        dll.pushToFront(1);
        dll.pushToBack(2);
        dll.pushToBack(3);
        dll.popFront(); // Removes 1
        dll.popBack();  // Removes 3
        assertEquals("|2|", dll.toString(), "The string representation should be '|2, |' after removing elements");
    }

}
