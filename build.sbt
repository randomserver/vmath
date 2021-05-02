lazy val scala213 = "2.13.5"
lazy val scala212 = "2.12.13"
lazy val supportedScalaVersions = List(scala213, scala212)

enablePlugins(GitVersioning)

ThisBuild / name := "vmath"
ThisBuild / scalaVersion := supportedScalaVersions.head
ThisBuild / crossScalaVersions := supportedScalaVersions
ThisBuild / organization := "se.randomserver"
ThisBuild / git.useGitDescribe := true

sys.env.get("GITHUB_TOKEN").map { password =>
  Seq(
    credentials += Credentials("Github Package Registry", "maven.pkg.github.com", "randomserver", password),
    publishTo := Some("Github Package Registry" at "https://maven.pkg.github.com/randomserver/math")
  )
}.getOrElse(Seq.empty)


scalacOptions += "-feature"
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.1" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"
