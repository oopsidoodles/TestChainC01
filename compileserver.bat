CD /D %~dp0
CD tomcat
CD webapps
CD server
CD WEB-INF
CD classes

javac -cp .;..\..\..\..\lib\servlet-api.jar MainServlet.java