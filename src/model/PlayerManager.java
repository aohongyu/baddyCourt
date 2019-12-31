package model;

import java.util.HashSet;
import java.util.*;

public class PlayerManager {
  public Set intermediate;
  public Set advance;
  public static int PLAYERNUM;

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
//        intermediate.add(player);

        // TODO: 测试用！！
        intermediate.add("i1");
        intermediate.add("i2");
        intermediate.add("i3");
        intermediate.add("i4");
        intermediate.add("i5");
        intermediate.add("i6");
        intermediate.add("i7");
        intermediate.add("i8");
//        intermediate.add("i9");
//        intermediate.add("i10");
//        intermediate.add("i11");
//        intermediate.add("i12");
//        intermediate.add("i13");
//        intermediate.add("i14");
//        intermediate.add("i15");
//        intermediate.add("i16");
//        intermediate.add("i17");
        PLAYERNUM += 8;
        // TODO: 测试用！！

//        PLAYERNUM++;
        break;
      case "Advance":
        if (advance.contains(player)) {
          break;
        }
        // advance.add(player);

        // TODO: 测试用！！
        advance.add("a1");
        advance.add("a2");
        advance.add("a3");
        advance.add("a4");
        advance.add("a5");
        advance.add("a6");
        advance.add("a7");
        advance.add("a8");
        advance.add("a9");
        advance.add("a10");
        advance.add("a11");
        advance.add("a12");
        advance.add("a13");
        advance.add("a14");
        advance.add("a15");
        advance.add("a16");
//        advance.add("a17");
        PLAYERNUM += 16;
        // TODO: 测试用！！

        // PLAYERNUM++;
        break;
    }
  }

  public void removePlayer(String player, String level) {
    switch (level) {
      case "Intermediate":
        if (intermediate.contains(player)) {
          intermediate.remove(player);
          PLAYERNUM--;
        }
        break;
      case "Advance":
        if (advance.contains(player)) {
          advance.remove(player);
          PLAYERNUM--;
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
