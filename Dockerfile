 FROM maven:3.8.4-openjdk-11-slim 


WORKDIR /commune-back


COPY target/backcommune-0.0.1-SNAPSHOT.jar   /commune-back/backcommune-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "/commune-back/backcommune-0.0.1-SNAPSHOT.jar"]

