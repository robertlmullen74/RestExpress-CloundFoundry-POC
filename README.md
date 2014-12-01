A Minimal RestExpress Server
============================
A template RestExpress project that contains no external dependencies.

To run the project:
1. git clone the project
2. cd to the robtestartifact directory
2. mvn clean package
3. mvn assembly:single


Cloud Foundry
==================
1. Create a demo account here https://run.pivotal.io
2. Download the CLI 
3. Login with the CLI 
4. cf push (app name) -p target/robtestartifact-1.0-SNAPSHOT-jar-with-dependencies.jar

You should see output like this, and then you can browse to 

terminal output...

```
robm@Robs-MacBook-Pro robtestartifact (master) $ cf push re-test2 -p target/robtestartifact-1.0-SNAPSHOT-jar-with-dependencies.jar 
Updating app re-test2 in org robmullen-org / space development as robertlmullen74@gmail.com...
OK

Uploading re-test2...
1 of 1 instances running

App started


OK
Showing health and status for app re-test2 in org robmullen-org / space development as robertlmullen74@gmail.com...
OK

requested state: started
instances: 1/1
usage: 512M x 1 instances
urls: restexpress-pivotal.cfapps.io
last uploaded: Mon Dec 1 03:19:34 +0000 2014

     state     since                    cpu    memory          disk   
0   running   2014-11-30 08:20:09 PM   0.0%   70.5M of 512M   111.9M of 1G  
```

If that's successful you should be able to curl (yoururl)/health -> {"status":"healthy"}

