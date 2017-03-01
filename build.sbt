import com.typesafe.sbt.SbtNativePackager.autoImport.NativePackagerHelper._

name := """zoopla-distence"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

javaOptions ++= Seq("-Dconfig.file=conf/application.conf")

resolvers += ("Unisay at bintray" at "http://dl.bintray.com/unisay/maven")

PlayKeys.devSettings := Seq("play.server.http.port" -> "8080")

topLevelDirectory := None

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "com.github.tomakehurst" % "wiremock" % "2.1.12" % Test
)

mappings in Universal ++= directory(baseDirectory.value / "nb-config")