package org.wildfly.swarm.examples.scala

import java.util.Date
import javax.ws.rs.{GET, Path}

@Path("/api")
class ScalaResource {

  @GET
  def get() = {
    "Hello at " + new Date()
  }
}
