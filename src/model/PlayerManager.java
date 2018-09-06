package model;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
  private List beginner;
  private List intermediate;
  private List advance;

  public PlayerManager() {
    this.beginner = new ArrayList<Player>();
    this.intermediate = new ArrayList<Player>();
    this.advance = new ArrayList<Player>();
  }

  @SuppressWarnings("unchecked")
  public void addPlayer(Player player, String level) {
    switch (level) {
      case "Beginner":
        beginner.add(player);
        break;
      case "Intermediate":
        intermediate.add(player);
        break;
      case "Advance":
        advance.add(player);
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
