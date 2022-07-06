lazy val root = (project in file("."))
  .settings(name := "codewars")
  .settings(moduleName := "codewars")
  .settings(version := "0.1")
  .settings(scalaVersion := "2.13.5")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12"

scalacOptions ++= Seq("-deprecation", "-feature")

addCommandAlias("check", ";scalafmtCheck;test:scalafmtCheck")
