name := """universe"""

scalaVersion := Common.scalaVersion

version := Common.version

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
  "org.json4s" %% "json4s-native" % "3.2.11",
  "org.scalatest" %% "scalatest" % "2.1.6" % "test",
  "org.specs2" % "specs2-core_2.11" % Common.specs2Version % "test"
)

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

scalacOptions in Test ++= Seq("-Yrangepos")
