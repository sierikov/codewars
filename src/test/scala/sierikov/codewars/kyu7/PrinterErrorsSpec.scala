package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec

class PrinterErrorsSpec extends AnyFlatSpec {

  import PrinterErrors.printerError

  s"printerError(\"aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz\")" should "return \"3/56\"" in {
    assertResult("3/56") {
      printerError("aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz")
    }
  }
}
