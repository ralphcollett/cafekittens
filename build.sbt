enablePlugins(ScalaJSPlugin)

name := "cafekittens"

version := "0.1-SNAPSHOT"

scalaVersion := "2.12.6"

scalaJSUseMainModuleInitializer := true

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.6"