import play.PlayScala

name := """test-wars"""

version := "0.1-SNAPSHOT"

lazy val testWars = (project in file(".")).enablePlugins(PlayScala).dependsOn(universe)
lazy val universe = (project in file("universe"))
lazy val testingStyles = (project in file("testing-styles")).dependsOn(universe)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  ws
)
