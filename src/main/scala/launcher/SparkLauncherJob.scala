package launcher

import org.apache.spark.launcher.SparkLauncher

import scala.collection.JavaConverters._
import scala.concurrent.{ ExecutionContext, Future }
import scala.io.Source

// http://henningpetersen.com/post/22/running-apache-spark-jobs-from-applications
class SparkLauncherJob(process: Process)(implicit executionContext: ExecutionContext) {

  def exitCode: Future[Int] = Future {
    process.waitFor()
  }

  def stderrIterator: Iterator[String] = {
    Source.fromInputStream(process.getErrorStream).getLines()
  }

  def stdoutIterator: Iterator[String] = {
    Source.fromInputStream(process.getInputStream).getLines()
  }

}

class SparkLauncherService(sparkHome: String, master: String, jar: String, mainClass: String, args: String*)(implicit executionContext: ExecutionContext) {


  def runSparkJob(): SparkLauncherJob = {

    val env = Map[String, String]()
//    val env = Map(
//      "opt1" -> "value1",
//    )

    val process = new SparkLauncher(env.asJava)
      .setSparkHome(sparkHome)
      .setAppResource(jar)
      .setMaster(master)
      .setVerbose(true)
      .setMainClass(mainClass)
      .addAppArgs("10")
      .launch()
    new SparkLauncherJob(process)
  }

}
