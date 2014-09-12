import com.mle.play.PlayProjects
import com.mle.sbtutils.SbtUtils
import sbt.Keys._
import sbt._

object PlayBuild extends Build {
  lazy val playBase = PlayProjects.playProject("play-base").settings(projectSettings: _*)

  lazy val projectSettings = SbtUtils.publishSettings ++ Seq(
    scalaVersion := "2.11.2",
    version := "0.1.1",
    SbtUtils.gitUserName := "malliina",
    SbtUtils.developerName := "Michael Skogberg",
    libraryDependencies ++= Seq("com.github.malliina" %% "util-play" % "1.5.8"),
    fork in Test := true,
    exportJars := false
  )
}