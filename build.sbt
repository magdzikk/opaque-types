name := "opaque-types-3"

version := "0.1"

//add the following line to your ~/.sbt/1.0/plugins/plugins.sbt
//addSbtPlugin("ch.epfl.lamp" % "sbt-dotty" % "0.5.3")

scalaVersion := "3.0.0-RC1"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.4" % "test"
libraryDependencies += "org.scalatest" %% "scalatest-wordspec" % "3.2.4" % "test"
