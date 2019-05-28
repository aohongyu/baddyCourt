package model;

import java.util.*;

public class CourtManager {
  public Map courtStatus;
  public PlayerManager playerManager = new PlayerManager();
  public Set alreadyPlayed = new HashSet();
  public Object intermediate[] = playerManager.getIntermediate().toArray();
  public Object advance[] = playerManager.getAdvance().toArray();
  public static int COURTNUM;

  public CourtManager() {
    this.courtStatus = new HashMap<>();
//    this.playerManager = new PlayerManager();
//    this.beginner = playerManager.getBeginner().toArray();
//    this.intermediate = playerManager.getIntermediate().toArray();
//    this.advance = playerManager.getAdvance().toArray();
  }

//  @SuppressWarnings("unchecked")
//  public void setUp1Court() {
//    courtStatus.put(1, setUpBeginner());
//  }
//
//  @SuppressWarnings("unchecked")
//  public String[] setUpBeginner() {
//    if (alreadyPlayed.size() >= PlayerManager.PLAYERNUM - 4) {
//      alreadyPlayed.clear();
//    }
//    String nextRound[] = new String[4];
//    int be = beginner.length;
//    int in = intermediate.length;
//    int i = 0;
//    while (i < 4) {
//      int randbe = (int)(Math.random() * be);
//      int randin = (int)(Math.random() * in);
//      System.out.println(beginner[randbe]);
//      while (!alreadyPlayed.contains(beginner[randbe])) {
//        nextRound[i] = (String) beginner[randbe];
//        alreadyPlayed.add(beginner[randbe]);
//        i++;
//      }
//
//      // check if all beginner players are already played
//      boolean status = false;
//      int j = 0;
//      while (j < be) {
//        if (!alreadyPlayed.contains(beginner[j])) {
//          status = true;
//        }
//        j++;
//      }
//
//      // if all beginner players are already played, add intermediate player
//      if (status) {
//        while (!alreadyPlayed.contains(intermediate[randin])) {
//          nextRound[i] = (String) intermediate[randin];
//          alreadyPlayed.add(intermediate[randin]);
//          i++;
//        }
//      }
//    }
//    return nextRound;
//  }
}
