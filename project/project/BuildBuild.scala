import sbt._

object BuildBuild extends Build {

  override lazy val settings = super.settings ++ Seq(
    Keys.scalaVersion := "2.10.4"
  ) ++ sbtPlugins

  def sbtPlugins = Seq(
    "com.github.malliina" % "sbt-play" % "0.0.1",
    "com.typesafe.play" % "sbt-plugin" % "2.3.4"
  ) map addSbtPlugin

  override lazy val projects = Seq(root)
  lazy val root = Project("plugins", file("."))
}