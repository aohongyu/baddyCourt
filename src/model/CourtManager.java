package model;

import java.util.*;

public class CourtManager {
  public Map courtStatus;

  public ArrayList<Object> intermediate = new ArrayList<>();
  public ArrayList<Object> advance = new ArrayList<>();

  public static int COURTNUM;
  public PlayerManager playerManager;
  public List<Integer> inLineUpIndex = new ArrayList<>();
  public List<Integer> adLineUpIndex = new ArrayList<>();
  /** A copy of current number of players. */
  public int currNumPlayerI = 0;
  public int currNumPlayerA = 0;

  public boolean initI = true;
  public boolean initA = true;

  public CourtManager(PlayerManager playerManager) {
    this.playerManager = playerManager;
    this.courtStatus = new HashMap<>();
  }

  @SuppressWarnings("unchecked")
  public void setUp3Court() {
    courtStatus.put(1, setUpInPlayer());
    courtStatus.put(2, setUpAdPlayer());
    courtStatus.put(3, setUpAdPlayer());
  }

  @SuppressWarnings("unchecked")
  public void setUp6Court() {
    courtStatus.put(1, setUpInPlayer());
    courtStatus.put(2, setUpInPlayer());
    courtStatus.put(3, setUpAdPlayer());
    courtStatus.put(4, setUpAdPlayer());
    courtStatus.put(5, setUpAdPlayer());
    courtStatus.put(6, setUpAdPlayer());
  }

  @SuppressWarnings("unchecked")
  public Object[] setUpInPlayer() {
    intermediate.addAll(playerManager.getIntermediate());
    Object[] nextRound = new Object[4];
    int in = playerManager.getNumIntermediate();
    Random random = new Random();

    if (inLineUpIndex.size() < 4 && !initI) {
      int i = 0;
      while (inLineUpIndex.size() > 0) {
        int index = random.nextInt(inLineUpIndex.size());
        int playerIndex = inLineUpIndex.remove(index);
        nextRound[i] = intermediate.get(playerIndex);
        i++;
      }
      currNumPlayerI = 0;
      initI = true;
    }

    if (initI) {
      while (currNumPlayerI < in) {
        inLineUpIndex.add(currNumPlayerI);
        currNumPlayerI++;
      }
      initI = false;
    }

    int playerInQueue = 0;
    while (nextRound[playerInQueue] != null) {
      playerInQueue++;
    }

    for (int i = playerInQueue; i < 4; ) {
      int index = random.nextInt(inLineUpIndex.size());
      int playerIndex = inLineUpIndex.remove(index);
      nextRound[i] = intermediate.get(playerIndex);
      i++;
    }

    return nextRound;
  }

  @SuppressWarnings("unchecked")
  public Object[] setUpAdPlayer() {
    advance.addAll(playerManager.getAdvance());
    Object[] nextRound = new Object[4];
    int in = playerManager.getNumAdvance();
    Random random = new Random();

    if (adLineUpIndex.size() < 4 && !initA) {
      int i = 0;
      while (adLineUpIndex.size() > 0) {
        int index = random.nextInt(adLineUpIndex.size());
        int playerIndex = adLineUpIndex.remove(index);
        nextRound[i] = advance.get(playerIndex);
        i++;
      }
      currNumPlayerA = 0;
      initA = true;
    }

    if (initA) {
      while (currNumPlayerA < in) {
        adLineUpIndex.add(currNumPlayerA);
        currNumPlayerA++;
      }
      initA = false;
    }

    int playerInQueue = 0;
    while (nextRound[playerInQueue] != null) {
      playerInQueue++;
    }

    for (int i = playerInQueue; i < 4;) {
      int index = random.nextInt(adLineUpIndex.size());
      int playerIndex = adLineUpIndex.remove(index);
      nextRound[i] = advance.get(playerIndex);
      i++;
    }

    return nextRound;
  }
}
