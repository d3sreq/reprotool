jetty + jenkins installation

1. Download Jetty application server from http://download.eclipse.org/jetty/
   (tested with ver. stable-8) and unpack it (for example to ~/jetty).
2. Download jenkins.war from http://jenkins-ci.org/ (tested with ver. 1.443)
   Save it into "webbaps" directory in jetty install dir (~/jetty/webapps/)
3. Run jetty using "java -jar start.jar".
4. When jetty is started open address "localhost:8080/jenkins" in browser.
5. Unpack reprotool.zip into ~/.jenkins/jobs
6. In jenkins applicaton go into configuration and hit "reload configuration
   from disk". Job "reprotool" should appear on the main page.