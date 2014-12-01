package robtestgroup.controller;

import org.restexpress.Request;
import org.restexpress.Response;

import robtestgroup.SimpleResponse;

public class SampleController
{
	public SampleController()
	{
		super();
	}

	public SimpleResponse read(Request request, Response response)
	{
		SimpleResponse so = new SimpleResponse();
		so.setStatus("healthy");
		return so;
		
	}
}
