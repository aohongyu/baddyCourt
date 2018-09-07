package model;

import java.util.HashSet;
import java.util.Set;

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
        beginner.add(player);
        PLAYERNUM++;
        break;
      case "Intermediate":
        intermediate.add(player);
        PLAYERNUM++;
        break;
      case "Advance":
        advance.add(player);
        PLAYERNUM++;
        break;
    }
  }

  public void removePlayer(String player, String level) {
    switch (level) {
      case "Beginner":
        beginner.remove(player);
        PLAYERNUM--;
        break;
      case "Intermediate":
        intermediate.remove(player);
        PLAYERNUM--;
        break;
      case "Advance":
        advance.remove(player);
        PLAYERNUM--;
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
}
