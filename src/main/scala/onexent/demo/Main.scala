package onextent.demo

import org.apache.spark.SparkEnv
import org.rogach.scallop.ScallopConf

object Main {
  def main(args: Array[String]) {
    object Args extends ScallopConf(args) {
      val msg = opt[String]("message", descr = "say something", default = Some("world"))
    }
    SparkEnv.get
    Args.verify()
    println(s"Hello ${Args.msg.getOrElse("what?")}")
  }
}

