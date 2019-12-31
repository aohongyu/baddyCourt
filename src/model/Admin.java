package model;

public class Admin {

  private PlayerManager playerManager;
  private CourtManager courtManager;

  public void initializeSystem() {
    this.playerManager = new PlayerManager();
    this.courtManager = new CourtManager(this.playerManager);
  }

  public PlayerManager getPlayerManager() {
    return playerManager;
  }

  public CourtManager getCourtManager() {
    return courtManager;
  }
}
