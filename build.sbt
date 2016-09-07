name := "math"

version := "1.0"

scalaVersion := "2.11.8"

scalacOptions += "-feature"
libraryDependencies += "org.scalautils" %% "scalautils" % "2.1.5"
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.13.2" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"