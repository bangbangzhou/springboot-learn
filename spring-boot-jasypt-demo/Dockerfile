FROM openjdk:11.0.12
VOLUME /tmp
ADD target/spring-boot-jasypt-demo-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]