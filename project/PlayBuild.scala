import com.mle.sbtutils.{SbtProjects, SbtUtils}
import sbt.Keys._
import sbt._
import bintray.Plugin.bintraySettings

object PlayBuild extends Build {
  lazy val playBase = SbtProjects.mavenPublishProject("play-base")
    .enablePlugins(play.PlayScala)
    .settings(projectSettings: _*)

  lazy val projectSettings = bintraySettings ++ Seq(
    scalaVersion := "2.11.6",
    version := "0.4.2",
    SbtUtils.gitUserName := "malliina",
    SbtUtils.developerName := "Michael Skogberg",
    libraryDependencies ++= Seq("com.github.malliina" %% "util-play" % "1.9.2"),
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
