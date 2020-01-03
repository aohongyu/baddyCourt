package model;

import java.util.HashSet;
import java.util.*;

public class PlayerManager {
  public Set intermediate;
  public Set advance;
  public static int PLAYERNUM;
  public static int INTNUM;
  public static int ADVNUM;

  public PlayerManager() {
    this.intermediate = new HashSet();
    this.advance = new HashSet();
  }

  @SuppressWarnings("unchecked")
  public void addPlayer(String player, String level) {
    switch (level) {
      case "Intermediate":
        if (intermediate.contains(player)) {
          break;
        }

        // for testing purpose
        //        intermediate.add("i1");
        //        intermediate.add("i2");
        //        intermediate.add("i3");
        //        intermediate.add("i4");
        //        intermediate.add("i5");
        //        intermediate.add("i6");
        //        intermediate.add("i7");
        //        intermediate.add("i8");
        //        intermediate.add("i9");
        //        intermediate.add("i10");
        //        intermediate.add("i11");
        //        intermediate.add("i12");
        //        intermediate.add("i13");
        //        intermediate.add("i14");
        //        intermediate.add("i15");
        //        intermediate.add("i16");
        //        intermediate.add("i17");
        //        intermediate.add("i18");
        //        intermediate.add("i19");
        //        intermediate.add("i20");
        //        intermediate.add("i21");
        //        intermediate.add("i22");
        //        intermediate.add("i23");
        //        intermediate.add("i24");
        //        intermediate.add("i25");
        //        intermediate.add("i26");
        //        intermediate.add("i27");
        //        intermediate.add("i28");
        //        intermediate.add("i29");
        //        intermediate.add("i30");
        //        intermediate.add("i31");
        //        intermediate.add("i32");
        //        intermediate.add("i33");
        //        intermediate.add("i34");
        //        PLAYERNUM += 34;
        //        INTNUM += 34;

        intermediate.add(player);
        PLAYERNUM++;
        INTNUM++;
        break;
      case "Advance":
        if (advance.contains(player)) {
          break;
        }

        // for testing purpose
        //        advance.add("a1");
        //        advance.add("a2");
        //        advance.add("a3");
        //        advance.add("a4");
        //        advance.add("a5");
        //        advance.add("a6");
        //        advance.add("a7");
        //        advance.add("a8");
        //        advance.add("a9");
        //        advance.add("a10");
        //        advance.add("a11");
        //        advance.add("a12");
        //        advance.add("a13");
        //        advance.add("a14");
        //        advance.add("a15");
        //        advance.add("a16");
        //        advance.add("a17");
        //        PLAYERNUM += 17;
        //        ADVNUM += 17;！

        advance.add(player);
        PLAYERNUM++;
        ADVNUM++;
        break;
    }
  }

  public void removePlayer(String player, String level) {
    switch (level) {
      case "Intermediate":
        if (intermediate.contains(player)) {
          intermediate.remove(player);
          PLAYERNUM--;
          INTNUM--;
        }
        break;
      case "Advance":
        if (advance.contains(player)) {
          advance.remove(player);
          PLAYERNUM--;
          ADVNUM--;
        }
        break;
    }
  }

  public int getNumIntermediate() {
    return intermediate.size();
  }

  public int getNumAdvance() {
    return advance.size();
  }

  public Set getIntermediate() {
    return intermediate;
  }

  public Set getAdvance() {
    return advance;
  }
}
