package launcher

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await}
import scala.concurrent.duration._

// http://henningpetersen.com/post/22/running-apache-spark-jobs-from-applications

/**
  * @author mpakhomov
  * @since 7/15/16
  */
object Launcher extends App {

  val job = new SparkLauncherService(
    "/home/mike/opt/spark",
    "spark://mp-desktop:7077",
    "/home/mike/spark-examples_2.11-1.0.jar",
    "org.apache.spark.examples.SparkPi",
    "30"
  ).runSparkJob()

  val exitCode = Await.result(job.exitCode, 1 hour)

  exitCode match {
    case 0 => println("Job result: SUCCESS")
    case exitCode => println(s"Job result: FAILURE, exitCode = $exitCode")
  }

  println("stdout:")
  println(job.stdoutIterator.mkString("\n"))

  println("\n" * 2)
  println("=" * 80)
  println("\n" * 2)

  println("stderr:")
  println(job.stderrIterator.mkString("\n"))
}
