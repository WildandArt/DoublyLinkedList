
/**
 * @package com.DoublyLinkedList
 * @brief This package contains the implementation of a doubly linked list.
 */

 package com.DoublyLinkedList;
 
 /**
  * @brief Interface for a Doubly Linked List.
  * 
  * This interface defines the operations that can be performed on a doubly linked list.
  * 
  * @tparam T The type of elements held in this list.
  */
 public interface DoublyLinkedList<T> {
 
     /**
      * @brief Adds an element to the front of the list.
      * @param element The element to be added.
      * @return The newly created node containing the element.
      */
     public Node<T> pushToFront(T element);
 
     /**
      * @brief Adds an element to the back of the list.
      * @param element The element to be added.
      * @return The newly created node containing the element.
      */
     public Node<T> pushToBack(T element);
 
     /**
      * @brief Retrieves the head node of the list.
      * @return The head node of the list.
      */
     public Node<T> getHead();
 
     /**
      * @brief Retrieves the tail node of the list.
      * @return The tail node of the list.
      */
     public Node<T> getTail();
 
     /**
      * @brief Retrieves the previous node of the given node.
      * @param node The node whose previous node is to be retrieved.
      * @return The previous node.
      */
     public Node<T> getPrev(Node<T> node);
 
     /**
      * @brief Retrieves the next node of the given node.
      * @param node The node whose next node is to be retrieved.
      * @return The next node.
      */
     public Node<T> getNext(Node<T> node);
 
     /**
      * @brief Removes and returns the element at the front of the list.
      * @return The element that was removed.
      * @throws RuntimeException If the list is empty.
      */
     public T popFront() throws RuntimeException;
 
     /**
      * @brief Removes and returns the element at the back of the list.
      * @return The element that was removed.
      */
     public T popBack();
 
     /**
      * @brief Returns the number of elements in the list.
      * @return The number of elements in the list.
      */
     public int count();
 
     /**
      * @brief Checks if the list is empty.
      * @return True if the list is empty, otherwise false.
      */
     public boolean isEmpty();
 
     /**
      * @brief Removes the element at the specified index.
      * @param index The index of the element to be removed.
      * @return The element that was removed.
      */
     public T remove(int index);
 
     /**
      * @brief Removes all occurrences of the specified element from the list.
      * @param o The element to be removed.
      * @return The number of occurrences removed.
      */
     public int remove(T o);
 
     /**
      * @brief Removes the specified node from the list.
      * @param node The node to be removed.
      * @return The element that was removed.
      */
     public T remove(Node<T> node);
 
     /**
      * @brief Retrieves the data from the specified node.
      * @param node The node from which to retrieve data.
      * @return The data contained in the node.
      */
     public T getData(Node<T> node);
 
     /**
      * @brief Inserts a new element before the specified node.
      * @param node The node before which the new element will be inserted.
      * @param data The data for the new element.
      * @return The newly created node containing the data.
      */
     public Node<T> insertBefore(Node<T> node, T data);
 
     /**
      * @brief Splices a segment of the list from one position to another.
      * @param dest The node at which to insert the spliced segment.
      * @param from The starting node of the segment to be spliced.
      * @param to The ending node of the segment to be spliced.
      */
     public void splice(Node<T> dest, Node<T> from, Node<T> to);
 }
 