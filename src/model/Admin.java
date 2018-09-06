package model;

public class Admin {

  private PlayerManager playerManager;
  private CourtManager courtManager;

  public void initializeSystem() {
    this.courtManager = new CourtManager();
    this.playerManager = new PlayerManager();
  }

  public PlayerManager getPlayerManager() {
    return playerManager;
  }

  public CourtManager getCourtManager() {
    return courtManager;
  }
}
