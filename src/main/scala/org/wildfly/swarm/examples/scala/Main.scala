package org.wildfly.swarm.examples.scala

import org.jboss.shrinkwrap.api.ShrinkWrap
import org.wildfly.swarm.Swarm
import org.wildfly.swarm.jaxrs.JAXRSArchive
import org.wildfly.swarm.undertow.WARArchive


object Main extends App {
  val api: Boolean = "true" == System.getProperty("api")

  println("\n\nStarting Scala App " + (if (api) "(API)" else "(static content)") + "\n\n")

  val container = new Swarm()
  if (api) {
    // jax rs
    val deployment = ShrinkWrap.create(classOf[JAXRSArchive], "scala-wildfly-swarm.war")
    deployment.addClass(classOf[ScalaResource])
    deployment.addAllDependencies()
    container.start().deploy(deployment)
  } else {
    // static content
    val deployment = ShrinkWrap.create(classOf[WARArchive], "scala-wildfly-swarm.war")
    deployment.staticContent()
    container.start.deploy(deployment)
  }
}
