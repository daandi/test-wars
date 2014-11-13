name := """testing_styles"""

scalaVersion := Commons.scalaVersion

version := Commons.version

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.1.6" % "test",
  "org.specs2" %% "specs2-core" % "2.4.9" % "test",
  "org.specs2" %% "specs2-matcher" % "2.4.9" % "test",
  "org.specs2" %% "specs2-html" % "2.4.9" % "test",
  "org.pegdown" % "pegdown" % "1.2.1" % "test"
)

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

resolvers += "bintray" at "http://dl.bintray.com/scalaz/releases"

//HTMLOutput
//(testOptions in Test) ++= Seq(
//  Tests.Argument(TestFrameworks.Specs2, "html"),
//  Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/scalatest/html")
//)

//XML-Output
//(testOptions in Test) ++= Seq(
//  Tests.Argument(TestFrameworks.ScalaTest, "-u", "target/scalatest/xml")
//)
