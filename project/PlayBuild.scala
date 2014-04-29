import com.mle.sbtutils.SbtUtils
import sbt._
import sbt.Keys._

object PlayBuild extends Build {
  lazy val utilPlay = SbtUtils.testableProject("play-base").settings(projectSettings: _*)

  lazy val projectSettings =
    SbtUtils.publishSettings ++
      play.Project.playScalaSettings ++ Seq(
      scalaVersion := "2.10.4",
      version := "0.0.4",
      SbtUtils.gitUserName := "malliina",
      SbtUtils.developerName := "Michael Skogberg",
      libraryDependencies ++= Seq(
        "com.github.malliina" %% "util-play" % "1.2.1"),
      fork in Test := true,
      exportJars := false
    )
}