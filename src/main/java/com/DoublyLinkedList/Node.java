
/**
 * @package com.DoublyLinkedList
 * @brief This package contains the implementation of a doubly linked list.
 */

 package com.DoublyLinkedList;

 /**
  * @brief Interface for a Node in a Doubly Linked List.
  * 
  * This interface defines the operations that can be performed on a node in a doubly linked list.
  * 
  * @tparam T The type of data held in this node.
  */
 public interface Node<T> {
 
     /**
      * @brief Retrieves the data contained in this node.
      * @return The data stored in this node.
      */
     T getData();
 
     /**
      * @brief Sets the data for this node.
      * @param data The data to be set in this node.
      */
     void setData(T data);
 
     /**
      * @brief Retrieves the next node in the list.
      * @return The next node.
      */
     Node<T> getNext();
 
     /**
      * @brief Sets the next node in the list.
      * @param node The node to be set as the next node.
      */
     void setNext(Node<T> node);
 
     /**
      * @brief Retrieves the previous node in the list.
      * @return The previous node.
      */
     Node<T> getPrev();
 
     /**
      * @brief Sets the previous node in the list.
      * @param node The node to be set as the previous node.
      */
     void setPrev(Node<T> node);
 }
 