name := "test-sangria-graphql-akka"

version := "0.1"

scalaVersion := "2.12.13"

val AkkaVersion = "2.6.8"
val AkkaHttpVersion = "10.2.3"
val AkkaHttpCirceVersion = "1.31.0"
val sangriaGraphQLVersion = "2.0.0"
val sangriaCirceVersion = "1.3.0"
val circeVersion = "0.13.0"

libraryDependencies ++= Seq(
  "de.heikoseeberger" %% "akka-http-circe" % AkkaHttpCirceVersion,
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion
)

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

libraryDependencies += "io.circe" %% "circe-optics" % circeVersion

libraryDependencies += "org.sangria-graphql" %% "sangria" % sangriaGraphQLVersion
libraryDependencies += "org.sangria-graphql" %% "sangria-slowlog" % "2.0.0-M1"
libraryDependencies += "org.sangria-graphql" %% "sangria-circe" % sangriaCirceVersion

libraryDependencies += "ch.megard" %% "akka-http-cors" % "1.1.1"
