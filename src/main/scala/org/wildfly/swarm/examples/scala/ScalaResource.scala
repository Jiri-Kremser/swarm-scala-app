package org.wildfly.swarm.examples.scala

import java.util.Date
import javax.ws.rs.{GET, Path}

@Path("/")
class ScalaResource {

  @GET
  def get() = {
    "Hello at " + new Date()
  }
}
