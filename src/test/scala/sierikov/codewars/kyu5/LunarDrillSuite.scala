package sierikov.codewars.kyu5

import sierikov.codewars.kyu5.LunarDrill.drill

class LunarDrillSuite extends org.scalatest.flatspec.AnyFlatSpec {
  "Mechanics Tests" should "detect drill" in {
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
         |´`:-->...........
         |´`:--->..........
         |´`:=>............
         |´`:==>...........
         |´`:===>..........
         |´`:->>...........
         |´`:-->>..........
         |´`:->>>..........
         |´`:=>>...........
         |´`:==>>..........""".stripMargin
      )
    )

    testCases.foreach { case (expected, canvas) =>
      assertResult(expected, s"\nCanvas:\n$canvas")(drill(canvas))
    }
  }

  it should "move with regular speed" in {
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

  it should "move with double speed" in {
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

  it should "detect double power" in {
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

  it should "move with tripple speed" in {
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

  it should "move with double speed and double power" in {
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

  it should "operate with multiple arms" in {
    val testCases = List(
      (1,
       """´`:->*...........
         |´`:-->*..........""".stripMargin
      ),
      (4,
       """´`:->@...........
         |´`:=>@...........""".stripMargin
      ),
      (2,
       """´`:->x...........
         |´`:=>@...........""".stripMargin
      ),
      (4,
       """´`:->*x..........
         |´`:->>>@.........""".stripMargin
      ),
      (8,
       """´`:===>@@@.......
         |´`:->>>..***.....
         |´`:-->>..xxx.....""".stripMargin
      ),
      (9,
       """´`:===>@@@.......
         |´`:->>>...***....
         |´`:-->>...xxx....""".stripMargin
      ),
      (10,
       """´`:===>@@@.......
         |´`:->>>...***....
         |´`:-->>...xxX....""".stripMargin
      )
    )

    testCases.foreach { case (expected, canvas) =>
      assertResult(expected, s"\nCanvas:\n$canvas")(drill(canvas))
    }
  }

  "Drilatronio" should "pass test field" in {
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

  it should "pass stress field" in {
    val testCases = List(
      (41,
       """´`:->...xxxx..****..****..****....
         |´`:->...****..xxxx..****..****....
         |´`:->...****..****..xxxx..****....
         |´`:->...****..****..****..xxxx....""".stripMargin
      ),
      (49,
       """´`:->...XXXX..****..****..****....
         |´`:=>...****..XXXX..****..****....
         |´`:=>...****..****..XXXX..****....
         |´`:->...****..****..****..XXXX....""".stripMargin
      ),
      (32,
       """´`:->>>.@@@@..****..****..****....
         |´`:=>>..****..@@@@..****..****....
         |´`:=>>..****..****..@@@@..****....
         |´`:->>>.****..****..****..@@@@....""".stripMargin
      ),
      (32,
       """´`:->...**..xx..XX..@@..
         |´`:->>..**..xx..XX..@@..
         |´`:->>>.**..xx..XX..@@..""".stripMargin
      ),
      (46,
       """´`:->...x**xx***xx****x.************
         |´`:->>>.***@xx@@X@.*@@*..@@@XXXxx@..""".stripMargin
      ),
      (36,
       """´`:--->***XXX**xx..**xx.xx
         |´`:-->>>.xx.XX@@@@.***....
         |´`:===>.X.@@@..XXXX**xxx*.
         |´`:=>>.xxX..@@.XX**...xxx.""".stripMargin
      ),
      (32,
       """´`:========>>XXX**xx.....
         |´`:->>>.xx.XX@@@@.***....
         |´`:-->>...@@@..XXXX*****.
         |´`:=>...xxX..@@.XXXXxxxxx""".stripMargin
      )
    )

    testCases.foreach { case (expected, canvas) =>
      assertResult(expected, s"\nCanvas:\n$canvas")(drill(canvas))
    }
  }
}
