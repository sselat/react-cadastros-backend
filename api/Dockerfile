FROM openjdk:11-ea-11
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/trilhaProvider-0.0.1.jar api.jar
EXPOSE 8081
ENTRYPOINT exec java $JAVA_OPTS -jar api.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar api.jar
