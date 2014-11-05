import play.PlayScala

name := """test_wars"""

version := "0.2"

lazy val test_wars = (project in file(".")).
                        enablePlugins(PlayScala).
                        dependsOn(universe)

lazy val universe = (project in file("universe"))

lazy val testing_styles = (project in file("testing_styles")).
                            dependsOn(universe)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  ws
)
