import play.PlayScala

scalaVersion := Commons.scalaVersion

version := Commons.version

lazy val universe = (project in file("universe"))

lazy val testing_styles = (project in file("testing_styles")).
                            dependsOn(universe)

lazy val death_star = (project in file("death_star")).
                        enablePlugins(PlayScala).
                        dependsOn(universe)

libraryDependencies ++= Seq(
  ws
)
