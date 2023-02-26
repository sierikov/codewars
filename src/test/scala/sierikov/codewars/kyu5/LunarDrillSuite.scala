package sierikov.codewars.kyu5

import sierikov.codewars.kyu5.LunarDrill.drill

class LunarDrillSuite extends org.scalatest.flatspec.AnyFlatSpec {
  "Mechanics Tests: Drill Type Detection" should "pass" in {
    val testCases = List(
      (0, "´`:->............"),
      (0, "´`:-->..........."),
      (0, "´`:--->.........."),
      (0, "´`:=>............"),
      (0, "´`:==>..........."),
      (0, "´`:===>.........."),
      (0, "´`:->>..........."),
      (0, "´`:-->>.........."),
      (0, "´`:->>>.........."),
      (0, "´`:=>>..........."),
      (0, "´`:==>>.........."),
      (0,
       """´`:->............
´`:-->...........
´`:--->..........
´`:=>............
´`:==>...........
´`:===>..........
´`:->>...........
´`:-->>..........
´`:->>>..........
´`:=>>...........
´`:==>>.........."""
      )
    )

    testCases.foreach { case (expected, canvas) =>
      assertResult(expected, s"\nCanvas:\n$canvas")(drill(canvas))
    }
  }

  "Mechanics Tests: Regular Speed" should "pass" in {
    val testCases = List(
      (1, "´`:->*..........."),
      (2, "´`:->.*.........."),
      (2, "´`:->**.........."),
      (3, "´`:->..*........."),
      (3, "´`:->***........."),
      (2, "´`:->x..........."),
      (3, "´`:->.x.........."),
      (4, "´`:->xx.........."),
      (4, "´`:->..x........."),
      (6, "´`:->xxx........."),
      (3, "´`:->X..........."),
      (4, "´`:->.X.........."),
      (6, "´`:->XX.........."),
      (5, "´`:->..X........."),
      (9, "´`:->XXX........."),
      (4, "´`:->@..........."),
      (5, "´`:->.@.........."),
      (8, "´`:->@@.........."),
      (6, "´`:->..@........."),
      (12, "´`:->@@@.........")
    )

    testCases.foreach { case (expected, canvas) =>
      assertResult(expected, s"\nCanvas:\n$canvas")(drill(canvas))
    }
  }

  "Mechanics Tests: Double Speed" should "pass" in {
    val testCases = List(
      (1, "´`:->>*.........."),
      (2, "´`:->>.*........."),
      (2, "´`:->>**........."),
      (3, "´`:->>..*........"),
      (3, "´`:->>***........"),
      (1, "´`:->>x.........."),
      (2, "´`:->>.x........."),
      (2, "´`:->>xx........."),
      (3, "´`:->>..x........"),
      (3, "´`:->>xxx........"),
      (2, "´`:->>X.........."),
      (3, "´`:->>.X........."),
      (4, "´`:->>XX........."),
      (4, "´`:->>..X........"),
      (6, "´`:->>XXX........"),
      (2, "´`:->>@.........."),
      (3, "´`:->>.@........."),
      (4, "´`:->>@@........."),
      (4, "´`:->>..@........"),
      (6, "´`:->>@@@........")
    )

    testCases.foreach { case (expected, canvas) =>
      assertResult(expected, s"\nCanvas:\n$canvas")(drill(canvas))
    }
  }

  "Mechanics Tests: Double Power" should "pass" in {
    val testCases = List(
      (1, "´`:=>*..........."),
      (2, "´`:=>.*.........."),
      (2, "´`:=>**.........."),
      (3, "´`:=>..*........."),
      (3, "´`:=>***........."),
      (1, "´`:=>x..........."),
      (2, "´`:=>.x.........."),
      (2, "´`:=>xx.........."),
      (3, "´`:=>..x........."),
      (3, "´`:=>xxx........."),
      (2, "´`:=>X..........."),
      (3, "´`:=>.X.........."),
      (4, "´`:=>XX.........."),
      (4, "´`:=>..X........."),
      (6, "´`:=>XXX........."),
      (2, "´`:=>@..........."),
      (3, "´`:=>.@.........."),
      (4, "´`:=>@@.........."),
      (4, "´`:=>..@........."),
      (6, "´`:=>@@@.........")
    )

    testCases.foreach { case (expected, canvas) =>
      assertResult(expected, s"\nCanvas:\n$canvas")(drill(canvas))
    }
  }

  "Mechanics Tests: Triple Speed" should "pass" in {
    val testCases = List(
      (1, "´`:->>>*........."),
      (2, "´`:->>>.*........"),
      (2, "´`:->>>**........"),
      (3, "´`:->>>..*......."),
      (3, "´`:->>>***......."),
      (1, "´`:->>>x........."),
      (2, "´`:->>>.x........"),
      (2, "´`:->>>xx........"),
      (3, "´`:->>>..x......."),
      (3, "´`:->>>xxx......."),
      (1, "´`:->>>X........."),
      (2, "´`:->>>.X........"),
      (2, "´`:->>>XX........"),
      (3, "´`:->>>..X......."),
      (3, "´`:->>>XXX......."),
      (2, "´`:->>>@........."),
      (3, "´`:->>>.@........"),
      (4, "´`:->>>@@........"),
      (4, "´`:->>>..@......."),
      (6, "´`:->>>@@@.......")
    )

    testCases.foreach { case (expected, canvas) =>
      assertResult(expected, s"\nCanvas:\n$canvas")(drill(canvas))
    }
  }

  "Mechanics Tests: Double Speed - Double Power" should "pass" in {
    val testCases = List(
      (1, "´`:=>>*.........."),
      (2, "´`:=>>.*........."),
      (2, "´`:=>>**........."),
      (3, "´`:=>>..*........"),
      (3, "´`:=>>***........"),
      (1, "´`:=>>x.........."),
      (2, "´`:=>>.x........."),
      (2, "´`:=>>xx........."),
      (3, "´`:=>>..x........"),
      (3, "´`:=>>xxx........"),
      (1, "´`:=>>X.........."),
      (2, "´`:=>>.X........."),
      (2, "´`:=>>XX........."),
      (3, "´`:=>>..X........"),
      (3, "´`:=>>XXX........"),
      (1, "´`:=>>@.........."),
      (2, "´`:=>>.@........."),
      (2, "´`:=>>@@........."),
      (3, "´`:=>>..@........"),
      (3, "´`:=>>@@@........")
    )

    testCases.foreach { case (expected, canvas) =>
      assertResult(expected, s"\nCanvas:\n$canvas")(drill(canvas))
    }
  }

  "Mechanics Tests: Multiple Arms" should "pass" in {
    val testCases = List(
      (1,
       """´`:->*...........
´`:-->*.........."""
      ),
      (4,
       """´`:->@...........
´`:=>@..........."""
      ),
      (2,
       """´`:->x...........
´`:=>@..........."""
      ),
      (4,
       """´`:->*x..........
´`:->>>@........."""
      ),
      (8,
       """´`:===>@@@.......
´`:->>>..***.....
´`:-->>..xxx....."""
      ),
      (9,
       """´`:===>@@@.......
´`:->>>...***....
´`:-->>...xxx...."""
      ),
      (10,
       """´`:===>@@@.......
´`:->>>...***....
´`:-->>...xxX...."""
      )
    )

    testCases.foreach { case (expected, canvas) =>
      assertResult(expected, s"\nCanvas:\n$canvas")(drill(canvas))
    }
  }

  "Sample Tests: Drillatronino" should "pass" in {
    val testCases = List(
      (12, "´`:->..**..**..**.."),
      (12, "´`:->>..**..**..**."),
      (12, "´`:=>..**..**..**.."),
      (12, "´`:->>>..**..**..**"),
      (12, "´`:=>>..**..**..**."),
      (18, "´`:->..*x..*X..*@.."),
      (14, "´`:->>..*x..*X..*@."),
      (14, "´`:=>..*x..*X..*@.."),
      (13, "´`:->>>..*x..*X..*@"),
      (12, "´`:=>>..*x..*X..*@."),
      (48, "´`:->..*xX@..*xX@..*xX@..*xX@.."),
      (32, "´`:->>..*xX@..*xX@..*xX@..*xX@."),
      (32, "´`:=>..*xX@..*xX@..*xX@..*xX@.."),
      (28, "´`:->>>..*xX@..*xX@..*xX@..*xX@"),
      (24, "´`:=>>..*xX@..*xX@..*xX@..*xX@.")
    )

    testCases.foreach { case (expected, canvas) =>
      assertResult(expected, s"\nCanvas:\n$canvas")(drill(canvas))
    }
  }

  "Sample Tests: Drillatron" should "pass" in {
    val testCases = List(
      (41,
       """´`:->...xxxx..****..****..****....
´`:->...****..xxxx..****..****....
´`:->...****..****..xxxx..****....
´`:->...****..****..****..xxxx...."""
      ),
      (49,
       """´`:->...XXXX..****..****..****....
´`:=>...****..XXXX..****..****....
´`:=>...****..****..XXXX..****....
´`:->...****..****..****..XXXX...."""
      ),
      (32,
       """´`:->>>.@@@@..****..****..****....
´`:=>>..****..@@@@..****..****....
´`:=>>..****..****..@@@@..****....
´`:->>>.****..****..****..@@@@...."""
      ),
      (32,
       """´`:->...**..xx..XX..@@..
´`:->>..**..xx..XX..@@..
´`:->>>.**..xx..XX..@@.."""
      ),
      (46,
       """´`:->...x**xx***xx****x.************
´`:->>>.***@xx@@X@.*@@*..@@@XXXxx@.."""
      ),
      (36,
       """´`:--->***XXX**xx..**xx.xx
´`:-->>>.xx.XX@@@@.***....
´`:===>.X.@@@..XXXX**xxx*.
´`:=>>.xxX..@@.XX**...xxx."""
      ),
      (32,
       """´`:========>>XXX**xx.....
´`:->>>.xx.XX@@@@.***....
´`:-->>...@@@..XXXX*****.
´`:=>...xxX..@@.XXXXxxxxx"""
      )
    )

    testCases.foreach { case (expected, canvas) =>
      assertResult(expected, s"\nCanvas:\n$canvas")(drill(canvas))
    }
  }
}
