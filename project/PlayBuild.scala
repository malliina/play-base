import com.mle.sbtutils.SbtProjects
import com.mle.sbtutils.SbtUtils.{developerName, gitUserName}
import sbt.Keys._
import sbt._

object PlayBuild extends Build {
  lazy val playBase = SbtProjects.testableProject("play-base")
    .enablePlugins(play.sbt.PlayScala, bintray.BintrayPlugin)
    .settings(projectSettings: _*)

  lazy val projectSettings = Seq(
    scalaVersion := "2.11.7",
    version := "0.5.2",
    gitUserName := "malliina",
    developerName := "Michael Skogberg",
    organization := s"com.github.${gitUserName.value}",
    libraryDependencies ++= Seq("com.github.malliina" %% "util-play" % "2.0.1"),
    resolvers ++= Seq(
      sbt.Resolver.jcenterRepo,
      "Bintray malliina" at "http://dl.bintray.com/malliina/maven"),
    fork in Test := true,
    exportJars := false,
    licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
  )
}
