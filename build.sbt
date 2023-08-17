import Dependencies.Libraries

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "json_reader",
    libraryDependencies ++= Libraries.Circe.all ++ Libraries.Derevo.all ++ Libraries.Http4s.all ++ Libraries.Cats.all
  )
