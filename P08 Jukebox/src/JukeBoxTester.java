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
import java.util.NoSuchElementException;

/**
 * Tester class for testing the functionality of the LinkedQueue, LinkedStack, Album, Song, and
 * Jukebox classes.
 */
public class JukeBoxTester {

  /**
   * Test the behavior of adding an element to the stack.
   * 
   * @return true if element is correctly added to the stack, false otherwise
   */
  public static boolean testStackAdd() {
    LinkedStack<Integer> test = new LinkedStack<>();
    test.push(1);
    test.push(2);
    test.push(3);

    if (!test.contains(1))
      return false;
    if (!test.contains(2))
      return false;
    if (!test.contains(3))
      return false;

    // the following creates an expected arraylist to compare against the actual stack
    ArrayList<Integer> stack = test.getList();
    ArrayList<Integer> expected = new ArrayList<>();
    expected.add(3);
    expected.add(2);
    expected.add(1);

    if (!stack.equals(expected))
      return false;

    System.out.println(test.getList());

    return true;
  }

  /**
   * Test the behavior of removing an element from the stack.
   * 
   * @return true if element is correctly removed from the stack, false otherwise
   */
  public static boolean testStackRemove() {
    LinkedStack<Integer> test = new LinkedStack<>();
    test.push(1);
    test.push(2);
    test.push(3);
    Integer removed = test.pop();

    System.out.println(test.getList());

    // makes sure the removed value is actully the one at the top
    if (!removed.equals(3))
      return false;

    // the stack should no longer contain the value 1 (and should be empty)
    if (test.contains(3))
      return false;

    ArrayList<Integer> stack = test.getList();
    ArrayList<Integer> expected = new ArrayList<>();
    expected.add(2);
    expected.add(1);

    if (!stack.equals(expected))
      return false;

    return true;
  }

  /**
   * Test the behavior of adding an element to the queue.
   * 
   * @return true if element is correctly added to the queue, false otherwise
   */
  public static boolean testQueueAdd() {
    LinkedQueue<String> test = new LinkedQueue<>();
    test.enqueue("a");
    test.enqueue("b");
    test.enqueue("c");

    System.out.println(test.getList());

    if (!test.contains("a"))
      return false;
    if (!test.contains("b"))
      return false;
    if (!test.contains("c"))
      return false;
    if (test.size() != 3)
      return false;

    // the following creates an expected arraylist to compare against the actual queue
    ArrayList<String> queue = test.getList();
    ArrayList<String> expected = new ArrayList<>();
    expected.add("a");
    expected.add("b");
    expected.add("c");

    if (!queue.equals(expected))
      return false;

    return true;
  }

  /**
   * Test the behavior of removing an element from the queue.
   * 
   * @return true if element is correctly removed from the queue, false otherwise
   */
  public static boolean testQueueRemove() {
    LinkedQueue<String> test = new LinkedQueue<>();
    test.enqueue("a");
    test.enqueue("b");
    test.enqueue("c");
    String removed = test.dequeue();

    System.out.println(test.getList());

    if (!removed.equals("a"))
      return false;
    if (test.contains("a"))
      return false;

    ArrayList<String> queue = test.getList();
    ArrayList<String> expected = new ArrayList<>();
    expected.add("b");
    expected.add("c");

    if (!queue.equals(expected))
      return false;

    return true;
  }

  /**
   * Test the behavior of peeking at the top element (for stack) and the front element (for queue).
   * 
   * @return true if the correct element returned for both data structures, false otherwise
   */
  public static boolean testPeek() {

    LinkedStack<Integer> test = new LinkedStack<>();
    test.push(1);
    test.push(2);
    int peekStack = test.peek();

    // the top of the stack should be 2 since LIFO
    if (peekStack != 2)
      return false;
    // nothing should have changed with the peek call
    if (!test.contains(1) || !test.contains(2))
      return false;

    LinkedQueue<String> test1 = new LinkedQueue<>();
    test1.enqueue("a");
    test1.enqueue("b");
    String peekQueue = test1.peek();

    if (!peekQueue.equals("a"))
      return false;
    if (!test1.contains("a") || !test1.contains("b"))
      return false;


    return true;
  }

  /**
   * This method tests whether the contains method correctly identifies whether a specific element
   * exists in a stack and a queue.
   * 
   * @return true if the test passes, false otherwise
   */
  public static boolean testContains() {
    LinkedStack<Integer> test = new LinkedStack<>();
    test.push(1);
    test.push(2);
    test.push(3);

    if (!test.contains(3))
      return false;

    LinkedQueue<String> test1 = new LinkedQueue<>();
    test1.enqueue("a");
    test1.enqueue("b");
    test1.enqueue("c");

    if (!test1.contains("c"))
      return false;


    return true;
  }

  /**
   * Test the behavior of getting the list of elements in the stack and queue.
   * 
   * @return true if method returns a correctly ordered list for both data structures, false
   *         otherwise
   */
  public static boolean testGetList() {
    LinkedStack<Integer> test = new LinkedStack<>();
    test.push(1);
    test.push(2);
    test.push(3);

    // correctStack is just used for testing; it is the stack that should occur if everything works
    // properly
    ArrayList<Integer> correctStack = new ArrayList<>();
    correctStack.add(3);
    correctStack.add(2);
    correctStack.add(1);

    ArrayList<Integer> getStack = test.getList();

    // the actual stack and correctStack should match
    if (!getStack.equals(correctStack))
      return false;



    LinkedQueue<String> test1 = new LinkedQueue<>();
    test1.enqueue("a");
    test1.enqueue("b");
    test1.enqueue("c");

    ArrayList<String> correctQueue = new ArrayList<>();
    correctQueue.add("a");
    correctQueue.add("b");
    correctQueue.add("c");

    ArrayList<String> getQueue = test1.getList();

    if (!getQueue.equals(correctQueue))
      return false;

    return true;
  }

  /**
   * Tests adding songs to an Album and verifies the size and content. Checks if songs are correctly
   * added in LIFO order.
   * 
   * @return true if it passes all test cases, false otherwise
   */
  public static boolean testAddSongToAlbum() {
    Song dupTester = new Song("Another Love", "Tom Odell");
    Album album = new Album("Chill");
    album.addSong(new Song("Home", "Edith Whiskers"));
    album.addSong(dupTester);
    album.addSong(new Song("The Night We Met", "Lord Huron"));
    // makes sure our album throws an error if we try to add duplicates
    try {
      album.addSong(dupTester);
      return false;
    } catch (IllegalArgumentException e) {
    }

    if (album.size() != 3)
      return false;
    System.out.println(album);

    return true;
  }

  /**
   * Tests removing a song from an Album and verifies the size and content after removal. Checks if
   * songs are correctly removed in LIFO order.
   * 
   * @return true if it passes all test cases, false otherwise
   */
  public static boolean testRemoveSongFromAlbum() {


    Song home = new Song("Home", "Edith Whiskers");
    Song love = new Song("Another Love", "Tom Odell");
    Song night = new Song("The Night We Met", "Lord Huron");

    Album album = new Album("Chill");

    // makes sure that if we try to remove from an empty album, an exception is thrown
    try {
      album.removeSong();
      return false;
    } catch (NoSuchElementException e) {

    }

    album.addSong(home);
    album.addSong(love);
    album.addSong(night);
    Song removed1 = album.removeSong();
    Song removed2 = album.removeSong();

    // the size should have been reduced by 1
    if (album.size() != 1)
      return false;
    if (!removed1.equals(night))
      return false;
    if (!removed2.equals(love))
      return false;
    System.out.println(album);

    return true;
  }

  /**
   * Tests the toString method of the Album class. Verifies that the returned string correctly
   * represents all songs in LIFO order.
   * 
   * @return true if it passes all test cases, false otherwise
   */
  public static boolean testAlbumToString() {
    Album album = new Album("Chill");
    Song song1 = new Song("Home", "Edith Whiskers");
    Song song2 = new Song("Another Love", "Tom Odell");
    Song song3 = new Song("The Night We Met", "Lord Huron");
    album.addSong(song1);
    album.addSong(song2);
    album.addSong(song3);

    // this StringBuffer models the correct toString representation of our album
    StringBuffer string = new StringBuffer();
    string.append(album.getAlbumName());
    string.append("\n" + song3);
    string.append("\n" + song2);
    string.append("\n" + song1);

    if (!album.toString().equals(string.toString()))
      return false;
    return true;
  }

  /**
   * Tests adding a song to the Jukebox and verifies the queue contents and size.
   * 
   * @return true if it passes all test cases, false otherwise
   */
  public static boolean testAddSongToJukebox() {
    JukeBox jukebox = new JukeBox(5);
    Song song1 = new Song("Song1", "Artist1");
    Song song2 = new Song("Song2", "Artist2");
    Song song3 = new Song("Song1", "Artist1");
    jukebox.addSongToQueue(song1);
    jukebox.addSongToQueue(song2);
    // makes sure our jukebox throws an error if we try to add a duplicate
    try {
      jukebox.addSongToQueue(song3);
      return false;
    } catch (IllegalArgumentException e) {
    }

    if (jukebox.capacity() != 5)
      return false;
    if (jukebox.size() != 2)
      return false;

    // we use this StringBuffer to compare against what the actual jukebox contains
    StringBuffer expected = new StringBuffer();
    expected.append(song1 + " -> ");
    expected.append(song2 + " -> ");
    expected.append("END");

    if (!jukebox.toString().equals(expected.toString()))
      return false;

    return true;
  }

  /**
   * Tests adding an album to the Jukebox and verifies the queue contents and size.
   * 
   * @return true if it passes all test cases, false otherwise
   */
  public static boolean testAddAlbumToJukebox() {
    JukeBox jukebox = new JukeBox(5);
    Song song1 = new Song("Song1", "Artist1");
    jukebox.addSongToQueue(song1);

    Album album = new Album("Chill");
    Song song2 = new Song("Home", "Edith Whiskers");
    Song song3 = new Song("Another Love", "Tom Odell");
    Song song4 = new Song("The Night We Met", "Lord Huron");
    Song song5 = new Song("Country Roads", "John Denver");
    Song song6 = new Song("Fly Me to the Moon", "Frank Sinatra");
    album.addSong(song2);
    album.addSong(song3);
    album.addSong(song4);
    album.addSong(song5);
    album.addSong(song6);

    jukebox.addAlbumToQueue(album);

    if (jukebox.capacity() != 5)
      return false;
    if (jukebox.size() != 5)
      return false;

    // just as before, this StringBuffer is used to compare against the actual
    // jukebox. The order should be 1, 4, 3, 2, since the album is a stack when
    // added to the queue.
    StringBuffer expected = new StringBuffer();
    expected.append(song1 + " -> ");
    expected.append(song6 + " -> ");
    expected.append(song5 + " -> ");
    expected.append(song4 + " -> ");
    expected.append(song3 + " -> ");
    expected.append("END");

    if (!jukebox.toString().equals(expected.toString()))
      return false;

    return true;
  }

  /**
   * Tests playing a song from the JukeboxQueue. Verifies that the song is removed from the queue
   * after playback.
   * 
   * @return true if it passes all test cases, false otherwise
   */
  public static boolean testPlaySongFromJukebox() {
    JukeBox jukebox = new JukeBox(5);

    // makes sure this throws an exception if theres no songs
    try {
      jukebox.playSong();
      return false;
    } catch (NoSuchElementException e) {
    }

    Song song1 = new Song("Song1", "Artist1");
    Song song2 = new Song("Song2", "Artist2");
    jukebox.addSongToQueue(song1);
    jukebox.addSongToQueue(song2);

    if (jukebox.capacity() != 5)
      return false;
    if (jukebox.size() != 2)
      return false;

    Song playedSong = jukebox.playSong();

    if (!playedSong.equals(song1))
      return false;
    if (jukebox.size() != 1)
      return false;

    StringBuffer expected = new StringBuffer();
    expected.append(song2 + " -> ");
    expected.append("END");

    if (!jukebox.toString().equals(expected.toString()))
      return false;

    return true;
  }

  /**
   * Tests shuffling the JukeBox queue. Verifies that the songs are reordered randomly after the
   * operation.
   * 
   * @return true if it passes all test cases, false otherwise
   */
  public static boolean testJukeboxShuffle() {
    JukeBox jukebox = new JukeBox(5);
    Song song1 = new Song("Song1", "Artist1");
    Song song2 = new Song("Song2", "Artist2");
    jukebox.addSongToQueue(song1);
    jukebox.addSongToQueue(song2);

    Album album = new Album("Chill");
    Song song3 = new Song("Home", "Edith Whiskers");
    Song song4 = new Song("Another Love", "Tom Odell");
    Song song5 = new Song("The Night We Met", "Lord Huron");
    album.addSong(song3);
    album.addSong(song4);
    album.addSong(song5);

    jukebox.addAlbumToQueue(album);

    StringBuffer expected = new StringBuffer();
    expected.append(song1 + " -> ");
    expected.append(song2 + " -> ");
    expected.append(song5 + " -> ");
    expected.append(song4 + " -> ");
    expected.append(song3 + " -> ");
    expected.append("END");

    if (!jukebox.toString().equals(expected.toString()))
      return false;

    jukebox.shuffleSongQueue();

    // the current toString should NOT equal the expected toString for the unshuffled jukebox
    if (jukebox.toString().equals(expected.toString()))
      return false;
    if (jukebox.size() != 5)
      return false;

    return true;

  }

  public static void main(String[] args) {
    // Running and printing results for all the tests

    boolean test1 = testStackAdd();
    System.out.println("testStackAdd: " + (test1 ? "PASS" : "FAIL"));

    boolean test2 = testStackRemove();
    System.out.println("testStackRemove: " + (test2 ? "PASS" : "FAIL"));

    boolean test3 = testQueueAdd();
    System.out.println("testQueueAdd: " + (test3 ? "PASS" : "FAIL"));

    boolean test4 = testQueueRemove();
    System.out.println("testQueueRemove: " + (test4 ? "PASS" : "FAIL"));

    boolean test5 = testPeek();
    System.out.println("testPeek: " + (test5 ? "PASS" : "FAIL"));

    boolean test6 = testContains();
    System.out.println("testContains: " + (test6 ? "PASS" : "FAIL"));

    boolean test7 = testGetList();
    System.out.println("testGetList: " + (test7 ? "PASS" : "FAIL"));

    boolean test8 = testAddSongToAlbum();
    System.out.println("testAddSongToAlbum: " + (test8 ? "PASS" : "FAIL"));

    boolean test9 = testRemoveSongFromAlbum();
    System.out.println("testRemoveSongFromAlbum: " + (test9 ? "PASS" : "FAIL"));

    boolean test10 = testAlbumToString();
    System.out.println("testAlbumToString: " + (test10 ? "PASS" : "FAIL"));

    boolean test11 = testAddSongToJukebox();
    System.out.println("testAddSongToJukebox: " + (test11 ? "PASS" : "FAIL"));

    boolean test12 = testAddAlbumToJukebox();
    System.out.println("testAddAlbumToJukebox: " + (test12 ? "PASS" : "FAIL"));

    boolean test13 = testPlaySongFromJukebox();
    System.out.println("testPlaySongFromJukebox: " + (test13 ? "PASS" : "FAIL"));

    boolean test14 = testJukeboxShuffle();
    System.out.println("testJukeboxShuffle: " + (test14 ? "PASS" : "FAIL"));

    System.out.println("ALL TESTS: " + (test1 && test2 && test3 && test4 && test5 && test6 && test7
        && test8 && test9 && test10 && test11 && test12 && test13 && test14 ? "PASS" : "FAIL"));
  }
}
