//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: JukeBox
// Course: CS 300 Fall 2024
//
// Author: Tristin Yun
// Email: tyun7@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////////// ASSISTANCE/HELP CITATIONS ////////////////////////////
//
// Persons: Nobody
// Online Sources: None
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;

/**
 * A generic singly-linked queue implementation.
 */
public class LinkedQueue<T> implements QueueADT<T> {

  // A reference to the LinkedNode currently at the back of the queue,
  // which contains the most-recently added value in the queue.
  private LinkedNode<T> back;

  // A reference to the LinkedNode currently at the front of the queue,
  // which contains the least-recently added value in the queue.
  private LinkedNode<T> front;

  // The number of values currently present in the queue.
  private int size;


  /**
   * Add a new element to the back of the queue, assumed to be non-null.
   * 
   * @param value - the value to be added
   */
  @Override
  public void enqueue(T value) {
    LinkedNode<T> newNode = new LinkedNode<>(value);
    if (this.front == null) {
      this.front = newNode;
    } else {
      this.back.setNext(newNode);
    }
    this.back = newNode;
    size++;
  }

  /**
   * Removes and returns the value added to this queue least recently
   * 
   * @return the least recently-added value, or null if the queue is empty
   */
  @Override
  public T dequeue() {
    if (isEmpty())
      return null;
    LinkedNode<T> temp = this.front;
    this.front = this.front.getNext();
    size--;
    return temp.getData();
  }

  /**
   * Accesses the value added to this queue least recently, without modifying the queue
   * 
   * @return the least recently-added value, or null if the queue is empty
   */
  @Override
  public T peek() {
    if (this.isEmpty())
      return null;
    return this.front.getData();
  }

  /**
   * Returns true if this queue contains no elements.
   * 
   * @return true if the queue contains no elements, false otherwise
   */
  @Override
  public boolean isEmpty() {
    if (this.front == null)
      return true;
    return false;
  }

  /**
   * Returns the number of elements in the queue.
   * 
   * @return the number of elements in the queue
   */
  @Override
  public int size() {
    if (this.front == null) {
      return 0;
    }
    return this.size;
  }

  /**
   * Removes all of the elements from the queue. The queue will be empty after this call returns.
   * 
   */
  @Override
  public void clear() {
    // Iterates through list and dequeues each node
    LinkedNode<T> current = this.front;
    while (current != null) {
      dequeue();
      current = current.getNext();
    }
  }

  /**
   * Returns true if this queue contains the element, false otherwise
   * 
   * @param value - the value to check
   * @return true if the queue contains the element, false otherwise
   */
  @Override
  public boolean contains(T value) {
    LinkedNode<T> current = this.front;
    // Iterates through list, and if it equals to desired data then return true, else false
    while (current != null) {
      if (current.getData().equals(value)) {
        return true;
      }
      current = current.getNext();
    }
    return false;
  }

  /**
   * Creates a copy of the current contents of this queue in the order they are present here, in
   * ArrayList form. This method should traverse the queue without removing any elements, and add
   * the values (not the nodes!) ' to an ArrayList in the order they appear in the queue, with the
   * front of the queue at index 0.
   * 
   * @return an ArrayList representation of the current state of this queue
   */
  public ArrayList<T> getList() {
    ArrayList<T> contents = new ArrayList<>();
    LinkedNode<T> current = this.front;
    // Iterates through list and adds each data of node into arraylist
    while (current != null) {
      contents.add(current.getData());
      current = current.getNext();
    }
    return contents;
  }


}
