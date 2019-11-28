lazy val scala213 = "2.13.1"
lazy val scala212 = "2.12.10"
lazy val scala211 = "2.11.12"
lazy val supportedScalaVersions = List(scala212, scala211)

enablePlugins(GitVersioning)

ThisBuild / name := "vmath"
ThisBuild / scalaVersion := scala212
ThisBuild / crossScalaVersions := supportedScalaVersions
ThisBuild / organization := "se.randomserver"
ThisBuild / git.useGitDescribe := true

scalacOptions += "-feature"
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.1" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"
