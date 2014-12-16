scalaVersion := Common.scalaVersion

version := Common.version

lazy val universe = (project in file("universe"))

lazy val testing_styles = (project in file("testing_styles")).
                            dependsOn(universe)
