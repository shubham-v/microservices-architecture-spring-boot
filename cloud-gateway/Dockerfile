FROM alpine:latest

ENV JAVA_HOME="/usr/lib/jvm/default-jvm/"
RUN apk add openjdk11

ENV PATH=$PATH:${JAVA_HOME}/bin

EXPOSE 9191

ADD build/libs/cloud-gateway-0.0.1.jar cloud-gateway.jar

ENTRYPOINT ["java", "-jar", "cloud-gateway.jar"]
