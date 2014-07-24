import com.mle.sbtutils.SbtUtils
import sbt._
import sbt.Keys._

object PlayBuild extends Build {
  lazy val playBase = SbtUtils.testableProject("play-base").enablePlugins(play.PlayScala).settings(projectSettings: _*)

  lazy val projectSettings = SbtUtils.publishSettings ++ Seq(
      scalaVersion := "2.11.2",
      version := "0.1.0",
      SbtUtils.gitUserName := "malliina",
      SbtUtils.developerName := "Michael Skogberg",
      libraryDependencies ++= Seq(
        "com.github.malliina" %% "util-play" % "1.4.3"),
      fork in Test := true,
      exportJars := false
    )
}