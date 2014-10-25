import com.mle.sbtutils.{SbtProjects, SbtUtils}
import sbt.Keys._
import sbt._

object PlayBuild extends Build {
  lazy val playBase = SbtProjects.mavenPublishProject("play-base")
    .enablePlugins(play.PlayScala)
    .settings(projectSettings: _*)

  lazy val projectSettings = Seq(
    scalaVersion := "2.11.2",
    version := "0.1.2",
    SbtUtils.gitUserName := "malliina",
    SbtUtils.developerName := "Michael Skogberg",
    libraryDependencies ++= Seq("com.github.malliina" %% "util-play" % "1.6.7"),
    fork in Test := true,
    exportJars := false
  )
}