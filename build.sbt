name := "play-crate"

organization := "io.crate"

version := "1.0"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % "2.3.3" % "provided",
  "io.crate" %% "crate-scala" % "1.0"
)

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"