 FROM maven:3.8.4-openjdk-11-slim 

# WORKDIR /commune-back

# COPY ./target/backcommune-0.0.1-SNAPSHOT.jar   /commune-back

# ENTRYPOINT ["java", "-jar", "backcommune-0.0.1-SNAPSHOT.jar"]


WORKDIR /commune-back


COPY target/backcommune-0.0.1-SNAPSHOT.jar   /commune-back/backcommune-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "/commune-back/backcommune-0.0.1-SNAPSHOT.jar"]

# WORKDIR /app

# # Copy the Spring Boot application JAR file into the container
# COPY target/my-spring-boot-app.jar /app/app.jar

# # Expose the port on which the application will run
# EXPOSE 8080

# # Run the Spring Boot application when the container starts
# CMD ["java", "-jar", "/app/app.jar"]