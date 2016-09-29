name := """zoopla-distence"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

javaOptions in Test += "-Dconfig.resource=conf/application.test.conf"

resolvers += ("Unisay at bintray" at "http://dl.bintray.com/unisay/maven")

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "com.github.tomakehurst" % "wiremock" % "2.1.12" % Test
)

