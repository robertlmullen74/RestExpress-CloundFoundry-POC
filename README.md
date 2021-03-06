Overview
============================
A minimal https://github.com/RestExpress RestExpress project that contains no external dependencies, to POC running a rest express server on cloud foundry web services.

Rest Express
==================
1. git clone the project
2. cd to the robtestartifact directory
3. mvn package assembly:single


Cloud Foundry
==================
1. Create a demo account here https://run.pivotal.io
2. Download the CLI 
3. Login with the CLI 
4. cf push (app name) -p target/robtestartifact-1.0-SNAPSHOT-jar-with-dependencies.jar


terminal output...

```
robm@Robs-MacBook-Pro robtestartifact (master) $ cf push re-test2 -p target/robtestartifact-1.0-SNAPSHOT-jar-with-dependencies.jar 
Updating app re-test2 in org robmullen-org / space development as robertlmullen74...
OK

Uploading re-test2...
1 of 1 instances running

App started


OK
Showing health and status for app re-test2 in org robmullen-org / space development as robertlmullen74...
OK

requested state: started
instances: 1/1
usage: 512M x 1 instances
urls: restexpress-pivotal.cfapps.io
last uploaded: Mon Dec 1 03:19:34 +0000 2014

     state     since                    cpu    memory          disk   
0   running   2014-11-30 08:20:09 PM   0.0%   70.5M of 512M   111.9M of 1G  
```

If that's successful you should be able to curl (yoururl)/health -> {"status":"veryhealthy"}

Details
====================
The main thing you have to do differently with cloud foundry and rest express is determine the port that the server is listening on, with cf that port is dynamically set at deploy time and added to the VCAP_APP_PORT environment variable, so you need to do something like this:

```
		if (System.getenv("VCAP_APP_PORT") == null)
		{
			port = 8080;
		}
		else{
			port = Integer.parseInt(System.getenv("VCAP_APP_PORT"));
		}
```
