FROM openjdk:17
LABEL maintainer="samuelanozie.me"
ADD target/bookmarky-0.0.1-SNAPSHOT.jar bookmarky.jar
ENTRYPOINT ["java", "-jar", "/bookmarky.jar"]