lazy val root = (project in file(".")).enablePlugins(play.sbt.routes.RoutesCompiler, SbtTwirl)

organization := "org.webjars"

name := "webjars-play"

version := "2.7.0-SNAPSHOT"

scalaVersion := "2.12.7"

crossScalaVersions := Seq("2.11.12", "2.12.4")

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions ++= Seq("-unchecked", "-deprecation")

sources in (Compile, play.sbt.routes.RoutesKeys.routes) ++= ((unmanagedResourceDirectories in Compile).value * "webjars.routes").get

sources in (Test, play.sbt.routes.RoutesKeys.routes) ++= ((unmanagedResourceDirectories in Test).value * "routes").get

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % "2.7.0-RC3" % "provided",
  "org.webjars" % "requirejs" % "2.3.5",
  "org.webjars" % "webjars-locator" % "0.32-1",
  "org.webjars" % "webjars-locator-core" % "0.35",
  "com.typesafe.play" %% "play-test" % "2.6.10" % "test",
  "com.typesafe.play" %% "play-specs2" % "2.6.10" % "test",
  "org.webjars" % "bootstrap" % "3.1.0" % "test",
  "org.webjars" % "react" % "0.12.2" % "test",
  "org.webjars" % "bootswatch-yeti" % "3.1.1" % "test"
)

licenses := Seq("MIT License" -> url("http://opensource.org/licenses/MIT"))

homepage := Some(url("http://github.com/webjars/webjars-play"))

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

scmInfo := Some(
  ScmInfo(
    url("https://github.com/webjars/webjars-play"),
    "scm:git:https://github.com/webjars/webjars-play.git"
  )
)

developers := List(
  Developer(
    id    = "jamesward",
    name  = "James Ward",
    email = "james@jamesward.com",
    url   = url("http://jamesward.com")
  )
)

useGpg := true

fork in Test := true
