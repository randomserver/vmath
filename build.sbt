lazy val scala213 = "2.13.5"
lazy val scala212 = "2.12.13"
lazy val supportedScalaVersions = List(scala213, scala212)

enablePlugins(GitVersioning)

ThisBuild / name := "vmath"
ThisBuild / scalaVersion := supportedScalaVersions.head
ThisBuild / crossScalaVersions := supportedScalaVersions
ThisBuild / organization := "se.randomserver"
ThisBuild / git.useGitDescribe := true

val oCreds = for {
  username <- sys.env.get("GITHUB_USER")
  password <- sys.env.get("GITHUB_TOKEN")
} yield Credentials("Github Package Registry", "maven.pkg.github.com", "randomserver", password)

oCreds match {
  case Some(value) => credentials += value
  case None => credentials ++= Seq.empty
}

scalacOptions += "-feature"
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.1" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"
