FROM amazoncorretto:11-alpine-jdk

MAINTAINER dmorandin

COPY target/yoProgramo-0.0.1-SNAPSHOT.jar  yoProgramo-app.jar

ENTRYPOINT ["java","-jar","/yoProgramo-app.jar"] 
