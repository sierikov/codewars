package sierikov.codewars.kyu7

import org.scalatest.funsuite.AnyFunSuite

class ComplementaryDNASuite extends AnyFunSuite {

  test("basic") {
    assertResult("TTTT")(ComplementaryDNA.makeComplement("AAAA"))
    assertResult("TAACG")(ComplementaryDNA.makeComplement("ATTGC"))
    assertResult("CATA")(ComplementaryDNA.makeComplement("GTAT"))
  }

  test("long") {
    assertResult("CATAGCTAGCTAGCTAGCTAATATAAAAGCTGCTCTAAATTTATATATATATATGCTCTCTTATGTCTATCTGTCTAAT")(
      ComplementaryDNA.makeComplement(
        "GTATCGATCGATCGATCGATTATATTTTCGACGAGATTTAAATATATATATATACGAGAGAATACAGATAGACAGATTA"
      )
    )
  }

}
