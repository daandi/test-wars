name := """testing_styles"""

scalaVersion := Common.scalaVersion

version := Common.version

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.1.6" % "test",
  "org.specs2" %% "specs2-core" % Common.specs2Version % "test,it",
  "org.specs2" %% "specs2-matcher" % Common.specs2Version % "test,it",
  "org.specs2" %% "specs2-html" % Common.specs2Version % "test,it"
)

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

scalacOptions in Test ++= Seq("-Yrangepos")


//HTMLOutput

//(testOptions in Test) ++= Seq(
//  Tests.Argument(TestFrameworks.Specs2, "html"),
//  Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/scalatest/html")
//)

//XML-Output

//(testOptions in Test) ++= Seq(
//  Tests.Argument(TestFrameworks.ScalaTest, "-u", "target/scalatest/xml")
//)
