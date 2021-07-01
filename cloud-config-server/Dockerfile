FROM alpine:latest

ENV JAVA_HOME="/usr/lib/jvm/default-jvm/"
RUN apk add openjdk11

ENV PATH=$PATH:${JAVA_HOME}/bin

EXPOSE 9296

ADD build/libs/cloud-config-server-0.0.1.jar cloud-config-server.jar

ENTRYPOINT ["java", "-jar", "cloud-config-server.jar"]
