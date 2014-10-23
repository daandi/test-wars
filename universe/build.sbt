name := """universe"""

version := "1.0"

scalaVersion := "2.11.2"

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.1.6" % "test",
  "org.specs2" % "specs2-core_2.11" % "2.4.6" % "test"
)

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)


