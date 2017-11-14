name := """play-java-starter-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

PlayKeys.externalizeResources := false

scalaVersion := "2.12.2"

libraryDependencies += guice

// Test Database
libraryDependencies += "com.h2database" % "h2" % "1.4.194"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "org.postgresql" % "postgresql" % "9.4-1206-jdbc42",
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "5.1.4.Final",
  "com.amazonaws" % "aws-java-sdk" % "1.11.52",
"com.jason-goodwin" %% "authentikat-jwt" % "0.4.5"
)
routesGenerator := InjectedRoutesGenerator
libraryDependencies ++= Seq(evolutions, jdbc)
libraryDependencies += javaForms
// Testing libraries for dealing ith CompletionStage...
libraryDependencies += "org.assertj" % "assertj-core" % "3.6.2" % Test
libraryDependencies += "org.awaitility" % "awaitility" % "2.0.0" % Test

routesGenerator := InjectedRoutesGenerator