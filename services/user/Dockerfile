FROM alpine:latest

ENV JAVA_HOME="/usr/lib/jvm/default-jvm/"
RUN apk add openjdk11

ENV PATH=$PATH:${JAVA_HOME}/bin

EXPOSE 9092

ADD build/libs/user-0.0.1.jar user.jar

ENTRYPOINT ["java", "-jar", "user.jar"]
