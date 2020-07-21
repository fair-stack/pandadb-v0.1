package cn.panda.semop

import cn.pandadb.commons.blob.{Blob, PropertyExtractor}
import cn.pandadb.commons.util.Configuration

/**
  * Created by bluejoe on 2019/2/17.
  */
class CommonPropertyExtractor extends PropertyExtractor {
  override def declareProperties() = Map("class" -> classOf[String])

  override def extract(x: Any): Map[String, Any] = {
    Map("class" -> x.getClass.getName)
  }

  override def initialize(conf: Configuration) {
  }
}

class CommonBlobPropertyExtractor extends PropertyExtractor {
  override def declareProperties() = Map("length" -> classOf[Int], "mime" -> classOf[String])

  override def extract(x: Any): Map[String, Any] = {
    x match {
      case b: Blob => Map("length" -> b.length, "mime" -> b.mimeType.text)
    }
  }

  override def initialize(conf: Configuration) {
  }
}