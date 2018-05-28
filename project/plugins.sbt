// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.13")

resolvers += "Play2war plugins release" at "http://repository-play-war.forge.cloudbees.com/release/"

addSbtPlugin("io.xogus" % "sbt-elastic-beanstalk" % "0.7.0")

addSbtPlugin("com.heroku" % "sbt-heroku" % "2.1.0")