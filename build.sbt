lazy val root = project
  .in(file("."))
  .settings(
    name := "codewars",
    moduleName := "codewars",
    description := "Collection of solutions to codewars problems",
    version := "0.0.2",
    scalaVersion := "3.2.1",
    scalacOptions ++= Seq("-deprecation", "-feature"),
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % Test
  )

addCommandAlias("check", ";scalafmtCheck;Test / scalafmtCheck")
