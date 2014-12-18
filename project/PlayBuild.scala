import com.mle.sbtutils.{SbtProjects, SbtUtils}
import sbt.Keys._
import sbt._

object PlayBuild extends Build {
  lazy val playBase = SbtProjects.mavenPublishProject("play-base")
    .enablePlugins(play.PlayScala)
    .settings(projectSettings: _*)

  lazy val projectSettings = Seq(
    scalaVersion := "2.11.4",
    version := "0.2.2",
    SbtUtils.gitUserName := "malliina",
    SbtUtils.developerName := "Michael Skogberg",
    libraryDependencies ++= Seq("com.github.malliina" %% "util-play" % "1.7.1"),
    resolvers ++= Seq(
      "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
      "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases/"),
    fork in Test := true,
    exportJars := false
  )
}