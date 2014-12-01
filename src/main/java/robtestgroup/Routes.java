package robtestgroup;

import org.jboss.netty.handler.codec.http.HttpMethod;
import org.restexpress.RestExpress;

import robtestgroup.controller.SampleController;


public abstract class Routes
{
	public static void define(RestExpress server)
    {
		server.uri("/health.{format}", new SampleController())
			.action("read", HttpMethod.GET)
			.method(HttpMethod.GET)
			.name("samplecollection");
    }
}
