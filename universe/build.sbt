name := """universe"""

scalaVersion := "2.11.4"

version := "0.4"

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
  "org.json4s" %% "json4s-native" % "3.2.11",

  "org.scalatest" %% "scalatest" % "2.1.6" % "test",
  "org.specs2" % "specs2-core_2.11" % "2.4.6" % "test"
)

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)
