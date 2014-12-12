scalaVersion := "2.11.4"

version := "0.4"

lazy val universe = (project in file("universe"))

lazy val testing_styles = (project in file("testing_styles")).
                            dependsOn(universe)
