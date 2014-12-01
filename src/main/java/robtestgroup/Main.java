package robtestgroup;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.restexpress.RestExpress;
import org.restexpress.pipeline.SimpleConsoleLogMessageObserver;
import org.restexpress.util.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import robtestgroup.serialization.SerializationProvider;

public class Main
{
	private static final String SERVICE_NAME = "RestExpressCloudFoundryTest";
	private static final Logger LOG = LoggerFactory.getLogger(SERVICE_NAME);

	public static void main(String[] args) throws Exception
	{
		RestExpress server = initializeServer(args);
		server.awaitShutdown();
	}

	public static RestExpress initializeServer(String[] args) throws IOException
	{
		RestExpress server = new RestExpress()
				.setBaseUrl("http://localhost")
				.setExecutorThreadCount(20)
				.addMessageObserver(new SimpleConsoleLogMessageObserver());

		Routes.define(server);
		Integer port;
		// This is the main change needed for cloud foundry
		// the port is dynamically added to the environment variables when the
		// app is deployed by cf
		if (System.getenv("VCAP_APP_PORT") == null)
		{
			port = 8080;
		}
		else{
			port = Integer.parseInt(System.getenv("VCAP_APP_PORT"));
		}
		System.out.println("port=" + port);
		server.bind(port);
		return server;
    }

}
