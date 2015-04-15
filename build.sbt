scalaVersion := Common.scalaVersion

version := Common.version

lazy val universe = project in file("universe")

lazy val testing_styles = project.
  in(file("testing_styles")).
  configs(IntegrationTest).settings(Defaults.itSettings : _*). // add integration test
  dependsOn(universe)

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

scalacOptions in Test ++= Seq("-Yrangepos")
