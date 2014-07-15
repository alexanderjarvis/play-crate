package io.crate.client

import scala.collection.JavaConverters._

import play.api._

class CratePlugin(application: Application) extends Plugin {

  private var started = false

  val DefaultHost = "localhost:4300"

  lazy val client = {
    import com.typesafe.config.ConfigFactory
    val config = ConfigFactory.load()
    val servers = Option(config.getStringList("crate.servers")) match {
      case Some(list) => list.asScala.toArray
      case None => Array(DefaultHost)
    }
    val client = ReactiveCrateClient(servers: _*)
    started = true
    Logger.info("Crate Plugin has started")
    client
  }

  override def onStart {
    client
  }

  override def onStop {
    if (started) {
      client.close()
      Logger.info("Crate Plugin has stopped")
    }
  }
}

object CratePlugin {

  def current(implicit app: Application): CratePlugin = app.plugin[CratePlugin] match {
    case Some(plugin) => plugin
    case _ => throw new PlayException("CratePlugin Error", "The CratePlugin has not been initialized! Please edit your conf/play.plugins file and add the following line: '300:io.crate.client.CratePlugin' (300 is an arbitrary priority and may be changed to match your needs).")
  }

}