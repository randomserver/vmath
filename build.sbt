lazy val scala213 = "2.13.1"
lazy val scala212 = "2.12.10"
lazy val supportedScalaVersions = List(scala213, scala212)

enablePlugins(GitVersioning)

ThisBuild / name := "vmath"
ThisBuild / scalaVersion := supportedScalaVersions.head
ThisBuild / crossScalaVersions := supportedScalaVersions
ThisBuild / organization := "se.randomserver"
ThisBuild / git.useGitDescribe := true

scalacOptions += "-feature"
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.1" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"
