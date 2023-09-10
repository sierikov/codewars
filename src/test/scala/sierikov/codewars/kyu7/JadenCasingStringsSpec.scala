package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class JadenCasingStringsSpec extends AnyFlatSpec {
  import JadenCasingStrings._
  "toJadenCase" should "pass basic tests" in {
    val testCases = List(
      ("most trees are blue", "Most Trees Are Blue"),
      ("X319gOnfbg89h8l WqoJwcRx bDRExnJ94Ksts EiTuHytPqzbDveEPTQE 3 EeYhXJCzNWNVhK7 hHE9fU7ixpZ7 85wngLZSBZMd5r68 u yze2BoJxEAxbu5 ZViKfGTHvpO0o 2VyWdrPXLvRFqUva BZcBGPuAQCo",
       "X319gonfbg89h8l Wqojwcrx Bdrexnj94ksts Eituhytpqzbdveeptqe 3 Eeyhxjcznwnvhk7 Hhe9fu7ixpz7 85wnglzsbzmd5r68 U Yze2bojxeaxbu5 Zvikfgthvpo0o 2vywdrpxlvrfquva Bzcbgpuaqco"
      )
    )

    testCases.foreach { case (s, expected) =>
      s.toJadenCase shouldBe expected
    }
  }
}
