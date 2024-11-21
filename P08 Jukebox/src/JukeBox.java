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
import java.util.Collections;
import java.util.NoSuchElementException;

/**
 * Represents a jukebox that holds a queue of songs for playback. The jukebox has a maximum capacity
 * to limit the number of songs that can be queued at once.
 */
public class JukeBox {
  private int capacity; // The maximum number of songs the jukebox can hold.
  private LinkedQueue<Song> songQueue; // Queue to store songs in the jukebox in FIFO order.

  /**
   * Constructs a new JukeBox with a specified capacity.
   * 
   * @param capacity - the maximum number of songs that can be held in the jukebox queue
   * @throws IllegalArgumentException - if the provided capacity is negative
   */
  public JukeBox(int capacity) {
    if (capacity < 0)
      throw new IllegalArgumentException("Capacity is negative");
    this.capacity = capacity;
    this.songQueue = new LinkedQueue<>();
  }

  /**
   * Adds a single song to the end of the queue if space allows.
   * 
   * @param song - the Song object to be added to the queue
   * @throws IllegalStateException    - if the queue is at maximum capacity
   * @throws IllegalArgumentException - if the song already exists in the queue
   */
  public void addSongToQueue(Song song) {
    if (this.songQueue.size() >= this.capacity) {
      throw new IllegalStateException("Queue is at max capacity");
    }
    if (this.songQueue.contains(song))
      throw new IllegalArgumentException("Song already in queue");

    this.songQueue.enqueue(song);
  }

  /**
   * Adds an entire album to the queue if space allows. Each song in the album is added individually
   * in order. Add as many songs as possible if album has size greater than space, skip songs
   * already added to queue.
   * 
   * @param album - a list of Song objects representing an album
   */
  public void addAlbumToQueue(Album album) {
    boolean error = false;
    while (error == false) {
      try {
        // we should stop if album.removeSong throws an error (no more songs in album)
        // or if this.addSongToQueue throws IllegalStateException (queue is at max capacity).
        // if this.addSongToQueue throws IllegalArgumentException (song already in queue)
        // then simply do not add this and move on.
        this.addSongToQueue(album.removeSong());
      } catch (NoSuchElementException e) {
        error = true;
      } catch (IllegalStateException i) {
        error = true;
      } catch (IllegalArgumentException a) {
      }
    }
  }

  /**
   * Plays and removes the song at the front of the queue.
   * 
   * @return the Song object that was played from the front.
   * @throws NoSuchElementException - if the queue is empty
   */
  public Song playSong() {
    if (this.songQueue.isEmpty())
      throw new NoSuchElementException("Queue is empty");
    return this.songQueue.dequeue();
  }

  /**
   * Shuffles the songs present in the queue. Size and capacity after this operation should remain
   * the same. Randomly reorder the contents of the song queue: 1. Create an ArrayList
   * representation of all of the elements of this queue, in order 2. Use Collections.shuffle() to
   * create a new random ordering of the contents 3. REPLACE the current contents of the queue with
   * the contents in their new order from the ArrayList
   * 
   */
  public void shuffleSongQueue() {
    ArrayList<Song> shuffled = this.songQueue.getList();
    Collections.shuffle(shuffled);
    // first clear the queue so we can re-add the shuffled song list
    this.songQueue.clear();
    for (Song s : shuffled) {
      this.songQueue.enqueue(s);
    }
  }

  /**
   * Returns the current number of songs in the queue.
   * 
   * @return the number of songs in the queue
   */
  public int size() {
    return this.songQueue.size();
  }


  /**
   * Returns the capacity of the queue.
   * 
   * @return the maximum number of songs that can be in the queue
   */
  public int capacity() {
    return this.capacity;
  }

  /**
   * Checks if the queue is full.
   * 
   * @return true if the queue has reached its capacity, false otherwise
   */
  public boolean isFull() {
    return this.songQueue.size() >= this.capacity;
  }

  /**
   * Checks if the queue is empty.
   * 
   * @return true if the queue has no songs, false otherwise
   */
  public boolean isEmpty() {
    return this.songQueue.isEmpty();
  }

  /**
   * Provides a string representation of the jukebox queue for debugging and display. Song
   * representation followed by -> and finishes with "END". Song1: Artist1 (Album1) -> Song2:
   * Artist2 (Album2) -> END
   * 
   * @return a string representing the queue, including song details in order
   */
  @Override
  public String toString() {
    StringBuffer string = new StringBuffer();
    for (Song s : this.songQueue.getList()) {
      string.append(s + " -> ");
    }
    string.append("END");
    return string.toString();
  }



}
