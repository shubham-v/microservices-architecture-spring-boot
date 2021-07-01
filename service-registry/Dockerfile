FROM alpine:latest

ENV JAVA_HOME="/usr/lib/jvm/default-jvm/"
RUN apk add openjdk11

ENV PATH=$PATH:${JAVA_HOME}/bin

EXPOSE 8761

ADD build/libs/service-registry-0.0.1.jar service-registry.jar

ENTRYPOINT ["java", "-jar", "service-registry.jar"]
