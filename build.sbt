name := "docker-entrypoint-cmd-demo"

version := "1.0"

scalaVersion := "2.10.6"

val sparkVersion = "1.6.1"

// additional libraries
libraryDependencies ++= Seq(
  "org.rogach" %% "scallop" % "2.0.1",  //Option parser
  // Spark framework libraries
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-hive" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion,
  "org.apache.spark" %% "spark-streaming-kafka" % sparkVersion,
  "com.databricks" %% "spark-csv" % "1.2.0",
  "amplab" % "spark-indexedrdd" % "0.3",
  "org.cloudera.spark.streaming.kafka" % "spark-kafka-writer" % "0.1.0"
    excludeAll(ExclusionRule(organization = "org.apache.spark")),
  "org.scalanlp" %% "breeze" % "0.11.2",
  // Logging libraries
  "org.slf4j" % "slf4j-api" % "1.7.12",
  "org.slf4j" % "slf4j-log4j12" % "1.7.12",
  "log4j" % "log4j" % "1.2.17",
  // test
  "org.scalatest" % "scalatest_2.10" % "3.0.0"
)

resolvers ++= Seq(
  "Repo at github.com/ankurdave/maven-repo" at "https://github.com/ankurdave/maven-repo/raw/master", //this is for indexedrdd ankurdave dependency
  "Spark Packages Repo" at "http://dl.bintray.com/spark-packages/maven",
  "Cloudera Repository" at "https://repository.cloudera.com/artifactory/cloudera-repos/"
)

assemblyMergeStrategy in assembly := {
  case x if x.endsWith("io.netty.versions.properties") => MergeStrategy.first
  case PathList("com",   "google", xs @ _*) => MergeStrategy.last
  case PathList("com",   "esotericsoftware", xs @ _*) => MergeStrategy.last
  case PathList("io",    "netty", xs @ _*) => MergeStrategy.last
  case PathList("org",   "slf4j", xs @ _*) => MergeStrategy.last
  case PathList("org",   "apache", xs @ _*) => MergeStrategy.last
  case "overview.html" => MergeStrategy.last
  case "plugin.xml" => MergeStrategy.last
  case "parquet.thrift" => MergeStrategy.last
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

mainClass in assembly := Some("onextent.demo.Main")
assemblyJarName in assembly := s"${name.value}.jar"

