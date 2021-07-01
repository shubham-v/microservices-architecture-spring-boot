FROM alpine:latest

ENV JAVA_HOME="/usr/lib/jvm/default-jvm/"
RUN apk add openjdk11

ENV PATH=$PATH:${JAVA_HOME}/bin

EXPOSE 9091

ADD build/libs/department-0.0.1.jar department.jar

ENTRYPOINT ["java", "-jar", "department.jar"]
