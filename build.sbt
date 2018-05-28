name := """trevis-api"""
organization := "com.trevis"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  guice,
  javaJdbc,
  javaWs
)


// https://mvnrepository.com/artifact/org.mongodb.morphia/morphia
libraryDependencies += "org.mongodb.morphia" % "morphia" % "1.3.0"

// https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient
libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.5"

// https://mvnrepository.com/artifact/com.google.code.gson/gson
libraryDependencies += "com.google.code.gson" % "gson" % "2.8.3"

// https://mvnrepository.com/artifact/javax.annotation/javax.annotation-api
libraryDependencies += "javax.annotation" % "javax.annotation-api" % "1.3.2"

// https://mvnrepository.com/artifact/org.simplejavamail/simple-java-mail
libraryDependencies += "org.simplejavamail" % "simple-java-mail" % "5.0.3"

// https://mvnrepository.com/artifact/io.swagger/swagger-play2
libraryDependencies += "io.swagger" %% "swagger-play2" % "1.6.0"

// https://mvnrepository.com/artifact/io.swagger.core.v3/swagger-annotations
libraryDependencies += "io.swagger.core.v3" % "swagger-annotations" % "2.0.2"

herokuAppName in Compile := "lit-mesa-28128"
enablePlugins(ElasticBeanstalkPlugin)
enablePlugins(DockerPlugin)

//
//// EBS Configs
//packageName in ElasticBeanstalk := "trevis-api-1.0-EBS.zip"
//elasticBeanstalkSources in ElasticBeanstalk := Seq(
//  baseDirectory.value / ".ebextensions" ,      // add .ebextensions folder
//  baseDirectory.value / "Dockerrun.aws.json"  // add Dockerrun.aws.json file
//)
////dockerLabels := Map(
////  "maintainer" -> "Yathindra Kodithuwakku <kgyoo8232@gmail.com>"
////)
//dockerExposedPorts := Seq(9000)
//dockerBaseImage := "java:latest"