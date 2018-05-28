FROM java:8
ENV SPRING_ACTIVE_PROFILE dev
ADD target/springboot-redis-0.0.1-SNAPSHOT.war app.war
VOLUME /tmp
EXPOSE 808
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.war"]