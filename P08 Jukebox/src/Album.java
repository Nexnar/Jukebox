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

import java.util.NoSuchElementException;

/**
 * Represents an album consisting of a stack of songs. The Album class allows adding and removing
 * songs in LIFO order.
 */
public class Album {
  private String albumName; // the name of the album
  private int size; // the number of songs currently in the album
  private LinkedStack<Song> trackList; // Stack to store songs in the album

  /**
   * Constructs an empty Album with a new LinkedStack to store song and size as zero.
   * 
   * @param albumName - the name of the album
   * @throws IllegalArgumentException - if the name is null or empty
   */
  public Album(String albumName) {
    if (albumName == null || albumName.isEmpty()) {
      throw new IllegalArgumentException("Album name is null/empty");
    }
    this.size = 0;
    this.albumName = albumName;
    this.trackList = new LinkedStack<>();
  }

  /**
   * Adds a song to the top of the album's track list and adds the Album reference to the song.
   * 
   * @param s - the Song object to be added to the album
   * @throws IllegalArgumentException - if the song already exists in the album
   */
  public void addSong(Song s) {
    if (this.trackList.contains(s)) {
      throw new IllegalArgumentException("Song already exists");
    }
    this.trackList.push(s);
    s.setAlbum(this);
    size++;
  }


  /**
   * Removes the most recently added song from the album.
   * 
   * @return the Song object removed from the top of the album
   * @throws NoSuchElementException - if the album is empty
   */
  public Song removeSong() {
    if (this.trackList.isEmpty())
      throw new NoSuchElementException();
    size--;
    return this.trackList.pop();
  }

  /**
   * Retrieves the song that is currently at the top of the album's track list, without removing it
   * from the stack.
   * 
   * @return the Song object at the top of the album, or null if the album is empty
   */
  public Song firstSong() {
    return this.trackList.peek();
  }

  /**
   * Retrieves the name of the album.
   * 
   * @return the name of the album
   */
  public String getAlbumName() {
    return this.albumName;
  }


  /**
   * Returns the number of songs currently in the album.
   * 
   * @return the number of songs in the album
   */
  public int size() {
    return this.size;
  }

  /**
   * Returns a string representation of the album, with the name of the album as the first line and
   * listing all songs from the top of the stack to the bottom. The output string should separate
   * Songs using a new line (\n). Top of the stack should be the first line of the string.
   * 
   * @return a string listing all songs in the album in LIFO order (top of stack comes FIRST)
   */
  @Override
  public String toString() {
    StringBuffer string = new StringBuffer();
    string.append(this.albumName);
    // Iterates through list and adds each song to StringBuffer
    for (Song s : this.trackList.getList()) {
      string.append("\n");
      string.append(s);
    }
    return string.toString();
  }


}
