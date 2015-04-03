import sbt.Keys._
import sbt._

object BuildBuild extends Build {

  override lazy val settings = super.settings ++ Seq(
    Keys.scalaVersion := "2.10.4",
    resolvers ++= Seq(
      "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
      "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases/")
  ) ++ sbtPlugins

  def sbtPlugins = Seq(
    "com.github.malliina" % "sbt-utils" % "0.0.6",
    "com.typesafe.play" % "sbt-plugin" % "2.3.8"
  ) map addSbtPlugin

  override lazy val projects = Seq(root)
  lazy val root = Project("plugins", file("."))
}