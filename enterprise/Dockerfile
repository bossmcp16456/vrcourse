FROM openjdk:11
LABEL maintainer="javaguides.net"
ADD target/enterprise-0.0.1-SNAPSHOT.jar enterprise-0.0.1-SNAPSHOT.jar.original
ENTRYPOINT ["java", "-jar", "enterprise-0.0.1-SNAPSHOT.jar.original"]