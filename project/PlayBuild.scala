import bintray.Plugin.bintraySettings
import com.mle.sbtutils.SbtProjects
import com.mle.sbtutils.SbtUtils.{developerName, gitUserName}
import sbt.Keys._
import sbt._

object PlayBuild extends Build {
  lazy val playBase = SbtProjects.testableProject("play-base")
    .enablePlugins(play.PlayScala)
    .settings(projectSettings: _*)

  lazy val projectSettings = bintraySettings ++ Seq(
    scalaVersion := "2.11.6",
    version := "0.4.3",
    gitUserName := "malliina",
    developerName := "Michael Skogberg",
    organization := s"com.github.${gitUserName.value}",
    libraryDependencies ++= Seq("com.github.malliina" %% "util-play" % "1.9.3"),
    resolvers ++= Seq(
      "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
      "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases/",
      sbt.Resolver.jcenterRepo,
      "Bintray malliina" at "http://dl.bintray.com/malliina/maven"),
    fork in Test := true,
    exportJars := false,
    licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
  )
}
