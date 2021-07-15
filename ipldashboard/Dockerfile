FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
RUN mkdir -p /opt/app/log
RUN mkdir -p /opt/log
ENTRYPOINT ["java","-jar","app.jar"]