FROM openjdk:11
VOLUME /tmp
EXPOSE 8002
ADD ./target/springboot-servicio-item-0.0.1-SNAPSHOT.jar item-server.jar
ENTRYPOINT ["java" , "-jar" ,"/item-server.jar"]