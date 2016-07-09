name := """spark-examples"""

version := "1.0"

scalaVersion := "2.11.8"

resolvers += "Typesafe Releases" at "https://repo.typesafe.com/typesafe/releases/"
resolvers += "sonatype-snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"
resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

libraryDependencies  ++= Seq(
  // other dependencies here
  "org.scalanlp" %% "breeze" % "0.12",
  // native libraries are not included by default. add this if you want them (as of 0.7)
  // native libraries greatly improve performance, but increase jar sizes.
  // It also packages various blas implementations, which have licenses that may or may not
  // be compatible with the Apache License. No GPL code, as best I know.
  "org.scalanlp" %% "breeze-natives" % "0.12",
  // the visualization library is distributed separately as well.
  // It depends on LGPL code.
  "org.scalanlp" %% "breeze-viz" % "0.12"
)

libraryDependencies += "org.scalactic" %% "scalactic" % "2.2.6"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.12.5" % "test"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.6.2"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "1.6.2"

libraryDependencies += "org.apache.spark" %% "spark-graphx" % "1.6.2"

libraryDependencies += "org.apache.spark" %% "spark-mllib" % "1.6.2"

libraryDependencies += "org.apache.spark" %% "spark-hive" % "1.6.2"

libraryDependencies += "org.apache.spark" %% "spark-streaming" % "1.6.2"

libraryDependencies += "org.apache.spark" %% "spark-streaming-twitter" % "1.6.2"

libraryDependencies += "org.apache.spark" %% "spark-streaming-kafka" % "1.6.2"

libraryDependencies += "org.apache.spark" %% "spark-streaming-flume" % "1.6.2"

libraryDependencies += "org.apache.spark" %% "spark-streaming-zeromq" % "1.6.2"

libraryDependencies += "com.github.scopt" %% "scopt" % "3.5.0"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.4.8"

libraryDependencies += "org.apache.kafka" % "kafka_2.11" % "0.10.0.0"

libraryDependencies += "com.twitter" % "algebird-core_2.11" % "0.12.1"

libraryDependencies += "org.apache.hbase" % "hbase" % "1.2.1"

libraryDependencies += "org.apache.hbase" % "hbase-client" % "1.2.1"

libraryDependencies += "org.apache.hbase" % "hbase-common" % "1.2.1"

//libraryDependencies += "org.scalaz" % "scalaz-core_2.11" % "7.2.0" withSources() withJavadoc()

//scalacOptions ++= Seq(
//  // Emit warning for usages of deprecated APIs
//  "-deprecation"
//  // Emit warning for usages of features that should be imported explicitly
//  , "-feature"
//  // Enable additional warnings where generated code depends on assumptions
//  , "-unchecked"
//  // Fail the compilation if there are any warnings
//  //, "-Xfatal-warnings" MP: If you uncomment it, your scala worksheets might stop working
//  // Enable or disable specific warnings
//  , "-Xlint:_"
//)
//
//scalacOptions ++= Seq(
//  // Do not adapt an argument list to match the receiver
//  "-Yno-adapted-args"
//  // Warn when dead code is identified
//  , "-Ywarn-dead-code"
//  // Warn when local and private vals, vars, defs, and types are are unused
//  , "-Ywarn-unused"
//  // Warn when imports are unused
//  , "-Ywarn-unused-import"
//  // Warn when non-Unit expression results are unused
//  , "-Ywarn-value-discard"
//)

incOptions := incOptions.value.withNameHashing(true)


