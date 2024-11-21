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
 * A generic singly-linked stack implementation
 */
public class LinkedStack<T> implements StackADT<T> {

  // A reference to the LinkedNode currently at the top of the stack,
  // which is null when the stack is empty.
  private LinkedNode<T> top;

  /**
   * Add a new element to the top of this stack, assumed to be non-null.
   * 
   * @param value the value to add
   */
  @Override
  public void push(T value) {
    LinkedNode<T> newNode = new LinkedNode<>(value);
    newNode.setNext(this.top);
    this.top = newNode;
  }

  /**
   * Removes and returns the value added to this stack most recently
   * 
   * @return the most recently-added value, or null if the stack is empty
   */
  @Override
  public T pop() {
    if (this.isEmpty())
      return null;
    T temp = this.top.getData();
    this.top = this.top.getNext();

    return temp;
  }

  /**
   * Accesses the value added to this stack most recently, without modifying the stack.
   * 
   * @return the most recently-added value, or null if the stack is empty
   */
  @Override
  public T peek() {
    if (this.isEmpty())
      return null;
    return this.top.getData();
  }

  /**
   * Returns true if this stack contains no elements.
   * 
   * @return true if the stack contains no elements, false otherwise
   */
  @Override
  public boolean isEmpty() {
    if (this.top == null)
      return true;
    return false;
  }

  /**
   * Returns true if this stack contains the element, false otherwise
   * 
   * @param value - the value to check
   * @return true if the stack contains the element, false otherwise
   */
  @Override
  public boolean contains(T value) {
    LinkedNode<T> current = this.top;
    // Iterates through list, and if it equals to desired data then return true, else false
    while (current != null) {
      if (current.getData().equals(value))
        return true;
      current = current.getNext();
    }
    return false;
  }

  /**
   * Creates a copy of the current contents of this stack in the order they are present here, in
   * ArrayList form. This method should traverse the stack without removing any elements, and add
   * the values (not the nodes!) to an ArrayList in the order they appear in the stack, with the top
   * of the stack at index 0.
   * 
   * @return an ArrayList representation of the current state of this stack
   */
  public ArrayList<T> getList() {
    ArrayList<T> contents = new ArrayList<>();
    // Iterates through list and adds each data of node into arraylist
    LinkedNode<T> current = this.top;
    while (current != null) {
      contents.add(current.getData());
      current = current.getNext();
    }

    return contents;
  }



}
