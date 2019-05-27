package model;

import java.util.HashSet;
import java.util.*;

public class PlayerManager {
  private Set beginner;
  private Set intermediate;
  private Set advance;
  public static int PLAYERNUM;

  public PlayerManager() {
    this.beginner = new HashSet();
    this.intermediate = new HashSet();
    this.advance = new HashSet();
  }

  @SuppressWarnings("unchecked")
  public void addPlayer(String player, String level) {
    switch (level) {
      case "Beginner":
        if (beginner.contains(player)) {
          break;
        }
        beginner.add(player);
        PLAYERNUM++;
        break;
      case "Intermediate":
        if (intermediate.contains(player)) {
          break;
        }
        intermediate.add(player);
        PLAYERNUM++;
        break;
      case "Advance":
        if (advance.contains(player)) {
          break;
        }
        advance.add(player);
        PLAYERNUM++;
        break;
    }
  }

  public void removePlayer(String player, String level) {
    switch (level) {
      case "Beginner":
        if (beginner.contains(player)) {
          beginner.remove(player);
          PLAYERNUM--;
        }
        break;
      case "Intermediate":
        if (intermediate.contains(player)) {
          intermediate.remove(player);
          PLAYERNUM--;
        }
        break;
      case "Advance":
        if (advance.contains(player)) {
          advance.remove(player);
          PLAYERNUM--;
        }
        break;
    }
  }

  public int getNumBeginner() {
    return beginner.size();
  }

  public int getNumIntermediate() {
    return intermediate.size();
  }

  public int getNumAdvance() {
    return advance.size();
  }

  public Set getBeginner() {
    return beginner;
  }

  public Set getIntermediate() {
    return intermediate;
  }

  public Set getAdvance() {
    return advance;
  }
}
