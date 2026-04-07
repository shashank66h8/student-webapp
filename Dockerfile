FROM tomcat:9

# Remove default apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR file into Tomcat
COPY target/student-webapp.war /usr/local/tomcat/webapps/student-webapp.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
