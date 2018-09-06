package model;

import java.util.HashMap;
import java.util.Map;

public class PlayerManager {
  private Map beginner;
  private Map intermediate;
  private Map advance;

  public PlayerManager() {
    this.beginner = new HashMap();
    this.intermediate = new HashMap();
    this.advance = new HashMap();
  }

  @SuppressWarnings("unchecked")
  public void addPlayer(String player, String level) {
    switch (level) {
      case "Beginner":
        beginner.put(player, level);
        break;
      case "Intermediate":
        intermediate.put(player, level);
        break;
      case "Advance":
        advance.put(player, level);
        break;
    }
  }

  public void removePlayer(Player player, String level) {
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

  public int getTotalNumPlayers() {
    return beginner.size() + intermediate.size() + advance.size();
  }
}
