package model;

import java.util.HashMap;
import java.util.Map;
import model.Exceptions.CourtCapacityException;

public class CourtManager {
  public Map courtStatus = new HashMap<>();
  public Integer numCourt = 0;

  @SuppressWarnings("unchecked")
  public void SetUpCourt(int courtNum) throws CourtCapacityException {
    numCourt = courtNum;
    if (courtNum == 1) {
      courtStatus.put(1, new String[4]);
    } else if (courtNum == 2) {
      courtStatus.put(1, new String[4]);
      courtStatus.put(2, new String[4]);
    } else if (courtNum == 3) {
      courtStatus.put(1, new String[4]);
      courtStatus.put(2, new String[4]);
      courtStatus.put(3, new String[4]);
    } else if (courtNum == 4) {
      courtStatus.put(1, new String[4]);
      courtStatus.put(2, new String[4]);
      courtStatus.put(3, new String[4]);
      courtStatus.put(4, new String[4]);
    } else if (courtNum == 5) {
      courtStatus.put(1, new String[4]);
      courtStatus.put(2, new String[4]);
      courtStatus.put(3, new String[4]);
      courtStatus.put(4, new String[4]);
      courtStatus.put(5, new String[4]);
    } else if (courtNum == 6) {
      courtStatus.put(1, new String[4]);
      courtStatus.put(2, new String[4]);
      courtStatus.put(3, new String[4]);
      courtStatus.put(4, new String[4]);
      courtStatus.put(5, new String[4]);
      courtStatus.put(6, new String[4]);
    } else {
      throw new CourtCapacityException("Please enter the valid number of courts.");
    }
  }
}
