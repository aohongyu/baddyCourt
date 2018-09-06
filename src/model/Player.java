package model;

public class Player {

  private String name;
  private String level;

  public Player(String name, String level) {
    this.name = name;
    this.level = level;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
