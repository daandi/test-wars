name := """testing_styles"""

scalaVersion := Commons.scalaVersion

version := Commons.version

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.1.6" % "test",
  "org.specs2" %% "specs2-core" % "2.4.6" % "test",
  "org.specs2" %% "specs2-matcher" % "2.4.6" % "test",
  "org.scalacheck" %% "scalacheck" % "1.11.6" % "test"
)

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)
