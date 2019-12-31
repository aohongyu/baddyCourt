package model;

import model.*;
import controller.StarterController;
import java.util.*;

public class CourtManager {
  public Map courtStatus;

  public Object[] intermediate;
  public Object[] advance;

  public static int COURTNUM;
  public PlayerManager playerManager;

  public CourtManager(PlayerManager playerManager) {
    this.playerManager = playerManager;
    this.courtStatus = new HashMap<>();
    //    this.intermediate = playerManager.getIntermediate().toArray();
    this.advance = playerManager.getAdvance().toArray();
  }

  @SuppressWarnings("unchecked")
  public void setUp1Court() {
    courtStatus.put(1, setUpPlayer());
  }

  @SuppressWarnings("unchecked")
  public Object[] setUpPlayer() {
    intermediate = playerManager.getIntermediate().toArray();
    System.out.println("!!!!" + intermediate.length);
    return intermediate;
  }
}
