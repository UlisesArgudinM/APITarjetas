FROM openjdk:11
VOLUME /tmp
ADD ./target/APITarjetas-1.0.jar rest-tarjetas.jar
ENTRYPOINT ["java", "-jar", "/rest-tarjetas.jar"]